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

step1 = {
  projectCd: '123',
  projectName: '项目名',
  projectPriceTotal: '9999',
  projectStatus: '0',
  projectStarttime: '2020-05-01',
  projectEndtime: '2020-06-01',
  projectCustomer: {
    // id null 추가 아님 갱신
    id: 1,
    // 필수
    customerName: '123',
    province: '123',
    city: '123',

    area: '123',
    address: '123',
    director: '123',
    salesVolumn: '123',
    developmentSkill: '123',
    // 더보기
    phone: '123',
    wechat: '123',
    description: '123',
    target: '123',
    productList: '123', 
    distribution: '123',
    salesMan: "[1,2,3]", // projectSalesMan 같음
    customerImage: '123', // list쪽
    status: '123', // 관리자쪽
  },
  projectSalesMan: "[1,2,3]"
}


step2 = {
  projectProduct: {
    projectId: 1, // id
    productName: 'qwe', // 产品名
    productMainMaterial: '["qwe","qwe"]', // 核心原料
    productSubMaterial: '["qwe","qwe"]', // 副原料
    productCategory: '11', // 分类
    productPackage: '11', // 包装类型
    productConcept: '11', // 产品概念
    productType: '11', // 饰品类型
    productQuantity: '11', // 数量
    productTargetPrice: '11', // 目标价格
    productDetail: 'qwe', // 详细说明
    productTargetContent: 'qwe', // 内容
    productImage: 'url', // 图片
  },
  projectPrice: {
    projectId: 1, // id
    projectProductId: null, // id
    productName: '111', // 产品名
    personInCharge: '111', // 负责人
    releaseDate: '2020-05-01', // 发行日
    dealPlace: '111', // 交易处
    orderQuantity: '111', // 订货数量
    actualInput: '111', // 实投入量
    unitWeight: '111', // 单位重量
    weight: '111', // 重量
    packageSpec: '111', // 包装规格
    theoryQuantity:'qwe', //理论数量
    yieldPercent:'qwe', //收率
    actualProduction:'qwe', //实际产生量
    priceList:'[json]', //价格列表
    descriptionList:'[json]', //说明列表
    remark:'qwe', //备注
    valueNoVat:'qwe', //估价 (VAT除外)
    specialComment:'qwe', //特技事项
  },
  projectRecordList: [
    {
      projectId: 1, // id
      recordId: 1, // id
      recordContent: [json], // 内容list
    },
    {
      projectId: 1, // id
      recordId: 2, // id
      recordContent: [json], // 内容list
    }
  ],
  projectTimelineList: [
    {
      projectId: 1, // id
      timelineContent: 'qwe', // 内容
      timelineAuthor: 'qwe', // 创建人
    },
    {
      projectId: 1, // id
      timelineContent: 'qwe', // 内容
      timelineAuthor: 'qwe', // 创建人
    }
  ]
}













