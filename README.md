# partitionjob
spring boot上构建spring batch远程分区Step，分布式多机处理，提高spring batch处理时效

批处理是企业级业务系统不可或缺的一部分，spring batch是一个轻量级的综合性批处理框架,可用于开发企业信息系统中那些至关重要的数据批量处理业务.SpringBatch基于POJO和Spring框架,相当容易上手使用,让开发者很容易地访问和利用企业级服务.spring batch是具有高可扩展性的框架,简单的批处理,复杂的大数据批处理作业都可以通过SpringBatch框架来实现。

# 项目特色
本项目不仅搭建了一个完整的可直接运行的spring batch远程分区处理实例，而且基于spring profile控制，可实现如下模式部署

- 一主多从
- 多主多从
- 主从混用

# 架构图
![输入图片说明](https://gitee.com/uploads/images/2018/0314/171005_410a8620_492218.png "屏幕截图.png")

# 原理简述

基于RabbitMQ，master节点将数据根据相关逻辑（ID，hash），拆分成一段一段要处理的数据集，然后将数据集放到消息中间件中（ActiveMQ，RabbitMQ ），从节点监听到消息，获取消息，读取消息中的数据集处理并发回结果

> 更多详情可移步博客：[kailing.pub](http://www.kailing.pub/article/index/arcid/196.html)
