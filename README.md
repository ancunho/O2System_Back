# O2System_Back

#### 2020.04.07
#####개인정보와 멤버
1. USER테이블 성(PROVINCE),도시(CITY),구역(AREA) 필드추가 ----- fixed
2. 성별: 1-남자, 2-여자   ------ fixed
3. /info/update --> @RequestBody추가   ------fixed
4. 파일정보 저장 로직 추가
5. 리스트에서 删除按钮 API로직 변경: ----fixed   api地址是：/api/member/delete   参数是User对象
6. 회원검색조건에 활성화/비활성화(启用/禁用) 조건추가
7. 会员启用/禁用API地址：/member/update/status       parameter: id   ------fixed
8. 初始化密码 : /member/update/reset/password       parameter: id   ------fixed
9. 删除： /member/delete                            parameter: id ----
10. 列表里添加会员注册时间field
11. 头像图片180X180

#####고객정보
1. 구역area 添加区域字段  -----fixed
2. 영업담당자추가--> key:id, value:realname    (多项)
3. 영업담당자필드추가 : salesman

#### 2020.04.14
#####프로젝트 인터페이스
1. 프로젝트 리스트 API
    1). 프로젝트명
    2). 고객명
    3). 영업담당자
    4). 제품
    5). 도시
    6). 이프로젝트의 Timeline
2. 


#####
1. 프로젝트 기본정보 ProjectBaseinfo
    1)프로젝트기본정보 + 2)고객정보 + 3)영업담당자정보(배열) 
    {
      projectCd: '123',
      projectName: '项目名',
      projectPriceTotal: '9999',
      projectStatus: '0',
      projectStarttime: '2020-05-01',
      projectEndtime: '2020-06-01',
      projectCustomerId: 1,
      projectSalesmanId: "[1,2,3]"
    }
2. 제품정보 ProjectProduct
    1). excel이랑 필드맞춰야됨---수량이 ProjectProduct에 없음
    

3. 이력정보 
    1). 통으로 왓다갓다. json 
    2). Tab정보 공통테이블에서 관리
    
4. 회원리스트 : 아이디 + 이름
5. 고객리스트 : 아이디 + 이름















