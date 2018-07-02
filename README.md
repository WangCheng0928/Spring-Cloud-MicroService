# Spring-Cloud-MicroService
# docker hub的用户名:tearsintopoetry
1、这个spring cloud项目以springboot微信点餐为基础
	主要包括订单模块(order)、商品模块(product)和用户模块(user)
	订单模块功能：
		创建订单
		完结订单
	商品模块功能：
		查询所有上线商品
		扣库存
	用户模块功能：
		查询用户信息
功能都比较简单，主要以实现这个服务的微服务为主

spring cloud微服务
1、服务注册与发现eureka
2、统一配置中心config
3、统一路由管理zuul
4、服务熔断hystrix
主要以上面4个为主，其他的包括各个模块的注册等。
