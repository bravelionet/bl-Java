### 触发点
    毕业在联想实习,做过一个功能是 poi导入及导出 excel,面试简历中写到此功能, 面试官会问poi技术出现的各种问题;
    由于时间久点记不清楚,建立此模板用于专门编写下poi实例,并且复现内存溢出及解决方案(重点)等...

###  简单了解 POI
        1. 结构：
            HSSF－ 提供读写Microsoft Excel格式档案的功能(☆☆☆☆☆)
                HSSF : 支持2003
            XSSF － 提供读写Microsoft Excel OOXML格式档案的功能 (☆☆☆☆☆)
               XSSF : 支持 2007
            SXSSF － 提供读支持海量数据导出  (☆☆☆☆☆)
            HWPF － 提供读写Microsoft Word格式档案的功能(☆☆☆☆)
            HSLF － 提供读写Microsoft PowerPoint格式档案的功能
            HDGF － 提供读写Microsoft Visio格式档案的功能    
        
    
### 操作步骤
        1. 一个 Excel 对应一个 wookbook, 一个wookbook对应多个sheet, 一个sheet对应多个行(row)和多个列(cell);
        2. 那么要导出一个 Excel 正确顺序如下:
            2.1. 建立 Workbook(HSSFWorkbook,XSSFWorkbook)打开或者创建 Excel对象
            2.2. 用户 Workbook 返回或者建立 sheet对象
            2.3. 用 sheet 返回行(Row)对象
            2.4. 用 行(Row)对象获取 Cell(列)对象
            2.5. 对 Cell对象进行读写
            2.6. return  
 
### 注
        HSSFWorkbook 最大行数是65536行,和255列限制
        XSSFWorkbook 最大行数是1048576行；
        3.8版本的POI对excel的导出操作，一般只使用HSSFWorkbook以及SXSSFWorkbook，HSSFWorkbook用来处理较少的数据量
        SXSSFWorkbook用来处理大数据量以及超大数据量的导出。