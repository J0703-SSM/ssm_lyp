//
//
//        from NEMbox.api import encrypted_request
//        import requests
//        import hashlib
//        import json
//
//
//        login_url = 'https://music.163.com/weapi/login?csrf_token='
//        fake_url = 'http://music.163.com/weapi/feedback/weblog?csrf_token='
//        user = username
//        pw = password
//        pw_ = hashlib.md5(pw.encode('utf-8')).hexdigest()
//
//
//        #网易对每个post请求进行了加密,而听完一首歌,post的data是fake_encode中text加密
//        def login_encode(username, password):
//        text = {
//        'username': username,
//        'password': password,
//        'rememberLogin': 'true'
//        }
//        data = encrypted_request(text)
//        return data
//
//        def fake_encode(sid ,csrf):
//        text = {'logs': json.dumps([{
//        'action': 'play',
//        'json': {"type": "song",
//        "download": 0,
//        "id": sid,
//        "time": 600,
//        "end": "ui",
//        "source": "list",
//        "sourceId": "576900073"}
//        }]),
//        'csrf_token': csrf
//        }
//        data = encrypted_request(text)
//        return data
//
//        #登录
//        s = requests.Session()
//        login = s.post(url=login_url, data=login_encode(user, pw_))
//        csrf = login.cookies.get('__csrf') #其实不加csrf也可以
//
//        #登录后,你就可以post你需要伪造的听歌request
//        #这里你可以用list,或者像前面回答一样构造sid表,循环请求就行了,例如:
//        sid_set = [86870, 86884, 86920, 86902, 86898, 86943, 86947, 86983, 87000, 87012, 87025]
//        for sid in sid_set:
//        p = s.post(url=fake_url, data=fake_encode(sid,csrf))