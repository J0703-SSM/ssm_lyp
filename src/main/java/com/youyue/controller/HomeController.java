package com.youyue.controller;

import com.youyue.domain.Admin_info;
import com.youyue.domain.Cost;
import com.youyue.domain.Service;
import com.youyue.service.Admin_infoService;
import com.youyue.service.CostService;
import com.youyue.service.ServiceService;
import com.youyue.utils.AjaxLoginResult;
import com.youyue.utils.mail.Mail;
import com.youyue.utils.mail.MailUtils;
import com.youyue.utils.vcode.VerifyCode;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Controller
public class HomeController {

    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    @Resource
    private Admin_infoService admin_infoService;

    @Resource
    private ServiceService serviceService;

    @Resource
    private CostService costService;

    private String text;

    @RequestMapping("/")
//    @RequestMapping({"/","login"})
    public String home() {
        return "login";
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }

//    @Controller
//    public class I18nController {
//
//        @RequestMapping(value = "/a")
//        public ModelAndView welcome() {
//            ModelAndView modelAndView = new ModelAndView("welcome");
//
//            return modelAndView;
//        }
//
//    }

    @RequestMapping(value = "sendsmm")
    public void sendsmm(String phone, HttpSession session) {

        String regex = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

        boolean matches = phone.matches(regex);

        if (matches) {

            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(Url);

            client.getParams().setContentCharset("GBK");
            method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");

            int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);

        System.out.println(mobile_code);

            session.setAttribute("mobile_code", String.valueOf(mobile_code));

            String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

            NameValuePair[] data = {
                    new NameValuePair("account", "C10712544"),
                    new NameValuePair("password", "8f4d9f1612c96a3d34423aa19668f4b1"),
                    new NameValuePair("mobile", phone),
                    new NameValuePair("content", content),
            };
            method.setRequestBody(data);

            try {
                client.executeMethod(method);

                String SubmitResult = method.getResponseBodyAsString();

                //System.out.println(SubmitResult);

                Document doc = DocumentHelper.parseText(SubmitResult);
                Element root = doc.getRootElement();

                String code = root.elementText("code");
                String msg = root.elementText("msg");
                String smsid = root.elementText("smsid");

                System.out.println(code);
                System.out.println(msg);
                System.out.println(smsid);

                if ("2".equals(code)) {
                    System.out.println("短信提交成功");
                }

            } catch (HttpException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (DocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

    @RequestMapping(value = "sendMail")
    public void sendMail(String email, HttpServletRequest request) {

//        new Thread(new Runnable() {
//            public void run() {
//                try {
//
//                    Thread.sleep(10000);    // 为了让用户充钱后感到满意的速度
//
//
//
//
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        int emailCode = (int) ((Math.random() * 9 + 1) * 100000);

        System.out.println(String.valueOf(emailCode));

        Admin_info adminInfo = admin_infoService.email(email);

//        System.out.println(adminInfo.getAdminCode());
//
//        System.out.println(adminInfo.getPassword());

        request.getServletContext().setAttribute("emailCode", String.valueOf(emailCode));

        try {
            Session session = MailUtils.createSession("smtp.163.com", "15842209819@163.com", "xxl101354@");
            Mail mail = new Mail("15842209819@163.com", email, "点击验证",
                    "这是你的验证码来自幼月汉化组: " + emailCode + "       <br>"
            + "请多多支持本汉化组的工作, 氪金改名" + "<br>" + "      你的用户名是: "
            + adminInfo.getAdminCode() + "    你的密码是: " + adminInfo.getPassword());
            MailUtils.send(session, mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    //    登录
    @ResponseBody
    @RequestMapping(value = "/login")
    public AjaxLoginResult index(String username,
                                 String password,
                                 String code,
                                 String phoneCode,
                                 String emailCode,
                                 HttpServletRequest request) {


//        System.out.println("111111");

//        Admin_info id = admin_infoService.findId();

//        List<Admin_role> adminRole = id.getAdminRole();


        AjaxLoginResult result = new AjaxLoginResult();

        Admin_info login = admin_infoService.login(username, password);
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println("************");
//        System.out.println(code);
//        System.out.println(text);


        if (login != null) {

            result.setErrorCode(0);
            request.getServletContext().setAttribute("login", login);
//            session.setAttribute("login", login);

        } else {

            result.setErrorCode(404);
            result.setMessage("用户名或密码错误，请重试");

        }

//        Admin_info id = admin_infoService.findId();

//        System.out.println(id);


//        ******************************

//        if (!code.equalsIgnoreCase(text)) {
//
//            result.setErrorCode(404);
////            result.setMessage();
//            result.setMess("验证码输入错误");
////            model.addAttribute("code", "验证码输入错误");
//        }


        String mobile_code = (String) request.getSession().getAttribute("mobile_code");


//        if (mobile_code == null || !mobile_code.equals(phoneCode)){
//
//            result.setErrorCode(404);
//            result.setPhonemess("手机验证码错误");
//
//        }
//
//        String eCode = (String) request.getServletContext().getAttribute("emailCode");
//
//        if (eCode == null || !eCode.equals(emailCode)){
//
//            result.setErrorCode(404);
//            result.setEamilmess("邮箱验证码错误");
//
//        }


//        ********************************

//        System.out.println(mobile_code);
//        System.out.println(mobile_code == null);

//        System.out.println(mobile_code.equals(phoneCode));
//        System.out.println(mobile_code);


//        System.out.println(code.equals(phoneCode));
        System.out.println(text);
//        System.out.println(code.equalsIgnoreCase(text));


//        System.out.println(login == null);

        return result;
    }

    /* 更改密码拦截验证 */
    @RequestMapping(value = "changePassword")
    public String changePassword(String oldPassword,
                                 String newPassword,
                                 String reNewPassword,
                                 HttpServletRequest request,
                                 Model model) {

//        System.out.println(oldPassword);
//        System.out.println(newPassword);
//        System.out.println(reNewPassword);

        Admin_info login = (Admin_info) request.getServletContext().getAttribute("login");

        if (!login.getPassword().equals(oldPassword)) {

            model.addAttribute("msg", "欧尼酱, 你的初始密码好像不太对哦 （￣へ￣）");

        } else if (StringUtils.isBlank(newPassword) || StringUtils.isBlank(reNewPassword)) {

            model.addAttribute("msg", "你是在暗示自己是baka么, 只有空密码才能记住");

        } else if (!newPassword.equals(reNewPassword)) {

            model.addAttribute("msg", "欧尼酱, 新密码要两次都相同哦 (/≧▽≦/)");

        } else if (oldPassword.equals(newPassword)) {

            model.addAttribute("msg", "这和原来的密码有什么区别么（╯‵□′）╯︵┴─┴");

        } else {

//            System.out.println(login.getAdminId());

            admin_infoService.updateById(newPassword, login.getAdminId());

            model.addAttribute("msg", "修改成功");

            login.setPassword(newPassword);

            request.getServletContext().setAttribute("login", login);

        }


        return "user/user_modi_pwd";

    }

    @RequestMapping(value = "/baidu")
    public String baidu(){
        return "success";
    }

    //    退出登录状态
    @RequestMapping(value = "quit")
    public String quit(HttpServletRequest request) {

        request.getServletContext().removeAttribute("login");

        return "login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("/role_list")
    public String role_list() {
        return "role/role_list";
    }

    @RequestMapping("/admin_list")
    public String admin_list() {
        return "admin/admin_list";
    }

    @RequestMapping("/fee_list")
    public String fee_list(Model model) {

        List<Cost> cost = costService.findAll();

        model.addAttribute("cost", cost);

        return "fee/fee_list";
    }

    @RequestMapping("/startFee")
    public String startFee(String costId){

        System.out.println(costId);

        costService.openBuyId(costId);

        return "redirect:/fee_list";
    }

    @RequestMapping("feeModi/{costId}")
    public String fee_modi(@PathVariable Integer costId,
                           Model model){

//        System.out.println(costId);

        Cost cost = costService.selectByPrimaryKey(costId);

        model.addAttribute("coster", cost);

//        System.out.println(cost);

        return "/fee/fee_modi";

    }


    @RequestMapping("updateFee")
    public String updateFee(String costid, String name, String base_duration,
                            String base_cost, String unit_cost, String descr){

        Cost cost = costService.selectByPrimaryKey(Integer.valueOf(costid));

        cost.setName(name);
        cost.setBaseDuration(Integer.valueOf(base_duration));
        cost.setBaseCost(Integer.valueOf(base_cost));
        cost.setUnitCost(Integer.valueOf(unit_cost));
        cost.setDescr(descr);

        costService.updateByPrimaryKeySelective(cost);

        System.out.println(costid);
        System.out.println(name);
        System.out.println(base_duration);
        System.out.println(base_cost);
        System.out.println(unit_cost);
        System.out.println(descr);


        return "redirect:/fee_list";
    }

    @RequestMapping("deleteFee")
    public String deleteFee(String costId){

        System.out.println(costId);

        costService.deleteByPrimaryKey(Integer.valueOf(costId));

        return "redirect:/fee_list";
    }


    @RequestMapping("/account_list")
    public String account_list() {


        return "account/account_list";
    }

    @RequestMapping("/service_list")
    public String service_list(Model model) {

        List<Service> all = serviceService.findAll(2);

        model.addAttribute("service", all);

        for (Service service : all) {
            System.out.println(service);
        }

        return "service/service_list";
    }

    @RequestMapping("/bill_list")
    public String bill_list() {
        return "bill/bill_list";
    }

    @RequestMapping("/report_list")
    public String report_list() {
        return "report/report_list";
    }

    @RequestMapping("/user_info")
    public String user_info(HttpServletRequest request) {

        Admin_info login = (Admin_info) request.getServletContext().getAttribute("login");

        System.out.println(login.getAdminId());


        admin_infoService.selectByPrimaryKey(login.getAdminId());

        return "user/user_info";

    }

    @RequestMapping("/user_modi_pwd")
    public String user_modi_pwd() {
        return "user/user_modi_pwd";
    }


    //    验证码返回结果
    @RequestMapping("validateCode")
    public void a(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        VerifyCode.output(image, response.getOutputStream());

        text = vc.getText();
//        System.out.println(text);
//        System.out.println(111);

    }


}
