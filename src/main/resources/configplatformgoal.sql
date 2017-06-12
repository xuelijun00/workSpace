use bi;
alter table configplatformgoal add targetprofit1 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit2 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit3 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit4 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit5 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit6 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit7 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit8 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit9 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit10 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add targetprofit11 int(11) not NULL DEFAULT 0;
alter table configplatformgoal add targetprofit12 int(11) not NULL DEFAULT 0;  

alter table configplatformgoal add actualprofit1 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit2 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit3 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit4 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit5 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit6 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit7 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit8 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit9 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit10 int(11) not NULL DEFAULT 0; 
alter table configplatformgoal add actualprofit11 int(11) not NULL DEFAULT 0;
alter table configplatformgoal add actualprofit12 int(11) not NULL DEFAULT 0;  

CREATE TABLE `configplatformgoal_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platform` varchar(20) NOT NULL COMMENT '平台',
  `name` varchar(20) NOT NULL COMMENT '平台名称',
  `report_date` date NOT NULL COMMENT '报表时间',
  `report_month` varchar(7) NOT NULL COMMENT '月份',
  `performance_targets` int(11) NOT NULL COMMENT '业绩目标',
  `quarterly_performance_targets` int(11) NOT NULL COMMENT '季度业绩目标',
  `sales` int(11) NOT NULL COMMENT '销售额',
  `quarterly_sales` int(11) NOT NULL COMMENT '季度销售额',
  `estimated_sales` int(11) NOT NULL COMMENT '预计销售额',
  `quarterly_estimated_sales` int(11) NOT NULL COMMENT '季度预计销售额',
  `estimated_percentage` int(11) NOT NULL COMMENT '预计百分比',
  `quarterly_estimated_percentage` int(11) NOT NULL COMMENT '季度预计百分比',
  `target_profit` int(11) NOT NULL COMMENT '目标利润',
  `actual_profit` int(11) NOT NULL COMMENT '实际利润',
  `net_profit_target` int(11) DEFAULT NULL COMMENT '净利目标',
  `net_profit_completion_rate` int(11) DEFAULT NULL COMMENT '净利完成率',
  `modify_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `bi`.`configplatformgoal_new` ( `report_month`,`platform`, `name`, `report_date`,  `performance_targets`, `quarterly_performance_targets`, `sales`, `quarterly_sales`, `estimated_sales`, `quarterly_estimated_sales`, `estimated_percentage`, `quarterly_estimated_percentage`, `target_profit`, `actual_profit`, `net_profit_target`, `net_profit_completion_rate`) 
select * from (
    SELECT '2017-01' month,platform, name, report_date, month1 as performanceTarget, quarter1 as quarterlySalesTarget,month1sales as monthSales, quarter1sales as quarterlySales,month1estimatesales as estimatedSales, quarter1estimatesales as quarterlyEstimatedSales, month1percent as estimatedPercent, quarter1percent as quarterlyEstimatedPercent,targetprofit1 as targetprofit,actualprofit1 as actualprofit,0 as a,0 as b FROM `configplatformgoal`
    union
    select '2017-02',platform, name, report_date, month2, quarter1,month2sales, quarter1sales,month2estimatesales, quarter1estimatesales, month2percent, quarter1percent,targetprofit2,actualprofit2,0,0 FROM `configplatformgoal`
    union
    select  '2017-03',platform, name, report_date, month3, quarter1,month3sales, quarter1sales, month3estimatesales, quarter1estimatesales, month3percent, quarter1percent,targetprofit3,actualprofit3,0,0  from configplatformgoal
    union
    select '2017-04',platform, name, report_date, month4, quarter2,month4sales, quarter2sales,month4estimatesales, quarter2estimatesales, month4percent, quarter2percent,targetprofit4,actualprofit4,0,0 from configplatformgoal
    union
    select '2017-05',platform, name, report_date, month5, quarter2,month5sales, quarter2sales,month5estimatesales, quarter2estimatesales, month5percent, quarter2percent,targetprofit5,actualprofit5,0,0 from configplatformgoal
    union
    select '2017-06',platform, name, report_date, month6, quarter2,month6sales, quarter2sales,month6estimatesales, quarter2estimatesales, month6percent, quarter2percent,targetprofit6,actualprofit6,0,0 from configplatformgoal
    union
    select '2017-07',platform, name, report_date, month7, quarter3,month7sales, quarter3sales,month7estimatesales, quarter3estimatesales, month7percent, quarter3percent,targetprofit7,actualprofit7,0,0 from configplatformgoal
    union
    select '2017-08',platform, name, report_date, month8, quarter3,month8sales, quarter3sales,month8estimatesales, quarter3estimatesales, month8percent, quarter3percent,targetprofit8,actualprofit8,0,0 from configplatformgoal
    union
    select '2017-09',platform, name, report_date, month9, quarter3,month9sales, quarter3sales,month9estimatesales, quarter3estimatesales, month9percent, quarter3percent,targetprofit9,actualprofit9,0,0 from configplatformgoal
    union
    select '2017-10',platform, name, report_date, month10, quarter4,month10sales, quarter4sales,month10estimatesales, quarter4estimatesales, month10percent, quarter4percent,targetprofit10,actualprofit10,0,0 from configplatformgoal
    union
    select '2017-11',platform, name, report_date, month11, quarter4,month11sales, quarter4sales,month11estimatesales, quarter4estimatesales, month11percent, quarter4percent,targetprofit11,actualprofit11,0,0 from configplatformgoal
    union
    select '2017-12',platform, name, report_date, month12, quarter4,month12sales, quarter4sales,month12estimatesales, quarter4estimatesales, month12percent, quarter4percent,targetprofit12,actualprofit12,0,0 from configplatformgoal
    ) a
    
    
CREATE TABLE `yks_order_weight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_number` varchar(255) DEFAULT NULL COMMENT '订单号',
  `logisticsType` varchar(255) DEFAULT NULL COMMENT '物流方式',
  `weight` float DEFAULT NULL COMMENT '重量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
