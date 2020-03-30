共同返回格式，`data`里放数据。
```nohighlight
{
  status: 0,    // Numer 状态码【0表示成功，非0表示出错】
  msg: '成功',  // String 信息
  data: any,    // Any 数据
}
```

# 全局
## 获取config list
```nohighlight
【地址】
POST(qs) :: /api/common/config

【请求】
{
  cnf_code: 'department',    // String code【department，question】
}

【响应】
{
  cnfValue: key,      // String id
  cnfNote: value,     // String 中文
  cnfNoteKr: value    // String 韩文
}
```

# 用户
## 登录
```nohighlight
【地址】
POST(qs) :: /api/login

【请求】
{
  username: 'admin',    // String 账号
  password: 'password', // String 密码
}

【响应】
token // String 认证码
```

## 退出
```nohighlight
【地址】
POST :: /api/user/logout
```

## 获取用户信息
```nohighlight
【地址】
GET :: /api/user/logout

【响应】
{
    'id': 3,                    // Number id
    'username': 'admin',        // String 账号
    'password': ',              // String 密码
    'roleNo': '1',              // 
    'role': 'ROLE_ADMIN',       // String 权限
    'status': null,             // String 是否激活
    'empno': null,              // String 员工号
    'realname': null,           // String 姓名
    'phone': '18521095572',     // String 电话号码
    'email': 'test@test.com',   // String 邮箱地址
    'department': null,         // String 部门名
    'sex': null,                // String 性别
    'birthday': null,           // String 生日年月日
    'wechat': null,             // String 微信号
    'qq': null,                 // String QQ号
    'address': null,            // String 居住地址
    'question': 'wenti',        // String 找密码问题
    'answer': 'daan',           // String 找密码答案
    'imagePhoto': null,         // String 会员照片
    'param1': null,             // String 其他字段1
    'param2': null,             // String 其他字段2
    'param3': null,             // String 其他字段3
    'param4': null,             // String 其他字段4
    'param5': null,             // String 其他字段5
    'createtime': null,         // String 生成时间
    'updatetime': null          // String 更新时间
}
```

## 注册
```nohighlight
【地址】
POST :: /api/user/create

【请求】
{
    'username': 'admin',        // String 账号
    'password': ',              // String 密码
    'realname': null,           // String 姓名
    'phone': '18521095572',     // String 电话号码
    'email': 'test@test.com',   // String 邮箱地址
    'empno': null,              // String 员工号
    'department': null,         // String 部门名
    'question': 'wenti',        // String 找密码问题
    'answer': 'daan',           // String 找密码答案
}
```

## 找回密码 3 - 1
```nohighlight
通过username获取问题

【地址】
POST(qs) :: /api/user/forget_get_question

【请求】
{
  username : 'cunho'    // String 账号
}

【响应】
wenti // String 问题
```


## 找回密码 3 - 2 
```nohighlight
답안 체크 및 token반환

【地址】
POST(qs) :: /api/user/forget_check_answer

【请求】
{
  username : 'cunho',    // String 账号
  question : 'wenti',    // String 找密码问题
  answer : 'xxxxx'       // String 找密码问题
}

【响应】
forgetToken // String 密码认证码
```

## 找回密码 3 - 3
```nohighlight
새 비밀번호 저장

【地址】
POST(qs) :: /api/user/forget_reset_password

【请求】
{
  username : 'cunho',      // String 账号
  passwordNew : 'xxxx',    // String 新密码
  forgetToken : 'xxxxx'    // String token
}
```

## username 중복체크
```nohighlight
회원가입할때 혹은 관리자가 username수정할때 사용

【地址】
POST(qs) :: /api/user/check_username

【请求】
{
  username : 'xxxx'    // String 账号
}
```


## Email 중복체크
```nohighlight
회원가입할때 혹은 관리자가 email 수정할때 사용

【地址】
POST(qs) :: /api/user/check_email

【请求】
{
  email : 'xxxx'   // String 邮箱地址
}
```

# 个人设置
## 修改个人信息
```nohighlight
【地址】
POST :: /api/user/info/update

【请求】
{
    'empno': null,              // String 员工号
    'realname': null,           // String 姓名
    'phone': '18521095572',     // String 电话号码
    'email': 'test@test.com',   // String 邮箱地址
    'department': null,         // String 部门名
    'sex': null,                // String 性别
    'birthday': null,           // String 生日年月日
    'wechat': null,             // String 微信号
    'qq': null,                 // String QQ号
    'address': null,            // String 居住地址
    'question': 'wenti',        // String 找密码问题
    'answer': 'daan',           // String 找密码答案
    'imagePhoto': null,         // String 会员照片
    'param1': null,             // String 其他字段1
    'param2': null,             // String 其他字段2
    'param3': null,             // String 其他字段3
    'param4': null,             // String 其他字段4
    'param5': null,             // String 其他字段5
}

【响应】
{
    'id': 3,                    // Number id
    'username': 'admin',        // String 账号
    'password': ',              // String 密码
    'roleNo': '1',              // 
    'role': 'ROLE_ADMIN',       // String 权限
    'status': null,             // String 是否激活
    'empno': null,              // String 员工号
    'realname': null,           // String 姓名
    'phone': '18521095572',     // String 电话号码
    'email': 'test@test.com',   // String 邮箱地址
    'department': null,         // String 部门名
    'sex': null,                // String 性别
    'birthday': null,           // String 生日年月日
    'wechat': null,             // String 微信号
    'qq': null,                 // String QQ号
    'address': null,            // String 居住地址
    'question': 'wenti',        // String 找密码问题
    'answer': 'daan',           // String 找密码答案
    'imagePhoto': null,         // String 会员照片
    'param1': null,             // String 其他字段1
    'param2': null,             // String 其他字段2
    'param3': null,             // String 其他字段3
    'param4': null,             // String 其他字段4
    'param5': null,             // String 其他字段5
    'createtime': null,         // String 生成时间
    'updatetime': null          // String 更新时间
}
```

## 修改密码
```nohighlight
【地址】
POST(qs) :: /api/user/update/password

【请求】
{
  passwordOld : 'xxxx',    // String 旧密码
  passwordNew : 'xxxxx'    // String 新密码
}
```

# 用户
## 获取list
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 新建
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 更新
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 删除
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 激活状态
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 负责项目list
```nohighlight
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
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 新建
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 更新
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```

## 删除
```nohighlight
【地址】

【请求】
{

}

【响应】
{
  
}
```