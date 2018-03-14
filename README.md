# partitionjob
spring boot上构建spring batch远程分区Step，分布式多机处理，提高spring batch处理时效

# 项目特色
本项目不仅搭建了一个完整的可直接运行的spring batch远程分区处理实例，而且基于spring profile控制，部署时可一主多从，多主多从，主从混用等

# 架构图
![输入图片说明](https://gitee.com/uploads/images/2018/0314/163250_d57b6053_492218.png "屏幕截图.png")

# 原理简述
基于RabbitMQ，master节点将数据根据相关逻辑（ID，hash），拆分成一段一段要处理的数据集，然后将数据集放到消息中间件中（ActiveMQ，RabbitMQ ），从节点监听到消息，获取消息，读取消息中的数据集处理并发回结果
