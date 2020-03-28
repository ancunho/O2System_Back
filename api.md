# 共同
共同返回格式，`data`里放数据。
```
{
  status: 0,   //（Numer）状态码【0表示成功，非0表示出错】
  msg: '成功',  //（String）信息
  data: any,    //（Any）数据
}
```

## 分页
```
【请求】
{
  username: 'admin',   //（String）账号
  password: 'password', //（String）密码
}

【响应】
{
  username: 'admin',   //（String）账号
  token: 'qeasdzxc', //（String）Token
}
```

# 全局
## 登录
```
【地址】
POST :: /api/login

【请求】
{
  username: 'admin',   //（String）账号
  password: 'password', //（String）密码
}

【响应】
{
    "status": 0,
    "msg": "登录成功",
    "data": {
        "id": 3,
        "username": "admin",
        "password": "",
        "roleNo": "1",
        "role": "ROLE_ADMIN",
        "status": null,
        "empno": null,
        "realname": null,
        "phone": "18521095572",
        "email": "test@test.com",
        "department": null,
        "sex": null,
        "birthday": null,
        "wechat": null,
        "qq": null,
        "address": null,
        "question": "wenti",
        "answer": "daan",
        "imagePhoto": null,
        "param1": null,
        "param2": null,
        "param3": null,
        "param4": null,
        "param5": null,
        "createtime": null,
        "updatetime": null
    },
    "success": true
}
```
## 退出
```
【地址】
POST :: /api/user/logout

【请求】
只请求地址

【响应】
{
    "status": 0,
    "msg": "已成功退出",
    "data": null,
    "success": true
}
```


## 获取用户信息
```
【地址】
POST :: /api/user/logout

【请求】
只请求地址

【响应】
{
    "status": 0,
    "msg": null,
    "data": {
        "id": 3,
        "username": "admin",
        "password": "",
        "roleNo": "1",
        "role": "ROLE_ADMIN",
        "status": null,
        "empno": null,
        "realname": null,
        "phone": "18521095572",
        "email": "test@test.com",
        "department": null,
        "sex": null,
        "birthday": null,
        "wechat": null,
        "qq": null,
        "address": null,
        "question": "wenti",
        "answer": "daan",
        "imagePhoto": null,
        "param1": null,
        "param2": null,
        "param3": null,
        "param4": null,
        "param5": null,
        "createtime": null,
        "updatetime": null
    },
    "success": true
}
```


## 注册
```
【地址】
POST :: /api/user/create

【请求】
{
  【Object】User
}

【响应】
{
    "status": 0,
    "msg": "新增用户成功",
    "data": null,
    "success": true
}
```

## 개인정보수정
```
【地址】
POST :: /api/user/info/update

【请求】
{
  【Object】User
}

【响应】
{
    "status": 0,
    "msg": "更新个人信息成功",
    "data": {
        "id": 3,
        "username": "admin",
        "password": null,
        "roleNo": null,
        "role": null,
        "status": null,
        "empno": null,
        "realname": null,
        "phone": "88888888",
        "email": null,
        "department": null,
        "sex": "1",
        "birthday": null,
        "wechat": "cunho910",
        "qq": null,
        "address": null,
        "question": null,
        "answer": null,
        "imagePhoto": null,
        "param1": null,
        "param2": null,
        "param3": null,
        "param4": null,
        "param5": null,
        "createtime": null,
        "updatetime": null
    },
    "success": true
}
```

## 找回密码 3 - 1
### 通过username获取问题
```
【地址】
POST :: /api/user/forget_get_question

【请求】
{
  username : 'cunho'
}

【响应】
{
    "status": 0,
    "msg": null,
    "data": "wenti",
    "success": true
}
```


## 找回密码 3 - 2
### 답안 체크 및 token반환
```
【地址】
POST :: /api/user/forget_check_answer

【请求】
{
  username : 'cunho',
  question : 'wenti',
  answer : 'xxxxx'
}

【响应】
{
    "status": 0,
    "msg": null,
    "data": "873f8d84-c0de-4fc9-b30c-9da2323dce8b",
    "success": true
}
```

## 找回密码 3 - 3
### 새 비밀번호 저장
```
【地址】
POST :: /api/user/forget_reset_password

【请求】
{
  username : 'cunho',
  passwordNew : 'xxxx',
  forgetToken : 'xxxxx'
}

【响应】
{
    "status": 0,
    "msg": "修改密码成功",
    "data": null,
    "success": true
}
```

## 修改密码
```
【地址】
POST :: /api/user/update/password

【请求】
{
  passwordOld : 'xxxx',
  passwordNew : 'xxxxx'
}

【响应】
{
    "status": 0,
    "msg": "密码更新成功",
    "data": null,
    "success": true
}
```

## 获取部门list
```
【地址】

【请求】
{
  
}

【响应】
{
  
}
```

## 获取问题list
```
【地址】

【请求】
{
  
}

【响应】
{
  
}
```

# 用户
## 获取list
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 新建
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 更新
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 删除
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 激活状态
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 负责项目list
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

# 客户
## 获取list
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 新建
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 更新
```
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 删除
```
【地址】

【请求】
{

}

【响应】
{
  
}
```