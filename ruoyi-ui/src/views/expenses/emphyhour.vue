<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <!-- <el-button style="color: white;background-color: #2468f2;" @click="dialogvisbel = true">新增</el-button> -->
            <div class="serachModel">
                <div class="topinput">
                    年月: <el-date-picker v-model="form.info2" type="datetime" placeholder="请选择上传时间">
                    </el-date-picker>

                </div>
                <div class="topinput">
                    项目: <el-select v-model="form.info3" placeholder="请选择项目">
                        <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                    </el-select>
                </div>

                <div style="display: grid;grid-template-columns: auto 1fr;align-items: center;">
                    <el-button type="primary">查询</el-button>
                </div>
                <div>
                    <el-button type="success">计算</el-button>
                </div>
            </div>
        </div>
        <!-- table -->
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="code" label="编码">
            </el-table-column>
            <el-table-column prop="name" label="名称">
            </el-table-column>
            <el-table-column prop="personnum" label="研发人员个数">
            </el-table-column>
            <el-table-column prop="totalhour" label="总工时">
            </el-table-column>
            <el-table-column prop="totalcost" label="总费用">
            </el-table-column>
           
            <el-table-column prop="" label="操作">
                <template slot-scope="scope">
                    <el-button @click="dialogvisbel = true">查看</el-button>
                    <!-- <el-button @click="dialogvisbel = true" type="primary">编辑</el-button>
                    <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button> -->
                </template>
            </el-table-column>
          

        </el-table>
        <!-- 分页 -->
        <el-pagination style="margin: 20px 0 ;" background layout="prev, pager, next" :total="1000">
        </el-pagination>
         <!-- 弹框 -->
         <el-dialog title="工时信息" :visible.sync="dialogvisbel" width="80%">
                <el-form ref="form" :model="form" label-width="100px">

                       <!-- 第二模块 人员信息-->
                <div class=" twoModel">
                    <div class="newadd">
                        <div>
                            <h2>人员信息</h2>
                        </div>
                    </div>
                   
                    <div class="personlist" v-for="item in projectPersons">
                        <div>项目编码： {{ item.code }}</div>
                        <div>项目名称： {{ item.prename }}</div>
                        <div>研发人员个数： {{ item.personnum }}</div>
                        <div>时间区域: {{ item.time }}</div>
                        <div>总工时: {{ item.totalhour }}</div>
                        <div>总费用: {{ item.totalcost }}</div>
                    </div>
                </div>

                <!-- table -->
                   <!-- table -->
        <el-table :data="tableData2" style="width: 100%">
            <el-table-column prop="code" label="人员编码">
            </el-table-column>
            <el-table-column prop="name" label="人员名称">
            </el-table-column>
            <el-table-column prop="roles" label="工时">
            </el-table-column>
            <el-table-column prop="dep" label="工资">
            </el-table-column>
            <el-table-column prop="wu1" label="养老">
            </el-table-column>
            <el-table-column prop="wu2" label="医疗">
            </el-table-column>
            <el-table-column prop="wu3" label="失业">
            </el-table-column>
            <el-table-column prop="wu4" label="工伤">
            </el-table-column>
            <el-table-column prop="wu5" label="生育">
            </el-table-column>
            <el-table-column prop="wu6" label="公积金">
            </el-table-column>
            <el-table-column prop="ohter" label="其他">
            </el-table-column>
            <el-table-column prop="all" label="汇总">
            </el-table-column>
         

        </el-table>
                   
                </el-form>
            </el-dialog>

    

    </div>

</template>

<script>
export default {
    data() {
        return {
            currentStep: 2,//当前步骤 
            showPopover: false,//编辑信息卡片
            queryParams: {},
            projectPersons:[
            { code:'0006',prename:'项目名称',personnum:'156',time:'2024-10-~2024-12',totalhour:'1560',totalcost:'15600'},
            ],
            phaseslist: [
                { id: 1, name: '验证阶段' },
                { id: 2, name: '小试阶段' },
                { id: 3, name: '中试阶段' },
                { id: 4, name: '产业化' },
            ],
            input1: '',
            personlist: [
                { id: 1, name: '张三' },
                { id: 2, name: '里斯' },
                { id: 3, name: '王五' },
            ],
            personSelect: '',
            personSelect2: '进行中',
            dateRange: '',
            dialogvisbel: false,
            tableData: [
              {code:'0006',name:'项目a',personnum:'156',totalhour:'1560',totalcost:'156000'},
              {code:'0006',name:'项目d',personnum:'254',totalhour:'25400',totalcost:'254000'},
              {code:'0006',name:'项目g',personnum:'156',totalhour:'1560',totalcost:'156000'},
                
            ],
            tableData2: [
                { code:'0001',year: '22024-10', name: '张三', roles: '10', dep: '5000', hour1: '15',
                 hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                 projectwages: '1200', pigeonhole: 'xx' ,ohter:'100',all:'5700'},
                 {code:'0001', year: '22024-10', name: '张三', roles: '10', dep: '5000', hour1: '15',
                 hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                 projectwages: '1200', pigeonhole: 'xx' ,ohter:'200',all:'5800'},
                 {code:'0001', year: '22024-10', name: '张三', roles: '10', dep: '5000', hour1: '15',
                 hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                 projectwages: '1200', pigeonhole: 'xx' ,ohter:'50',all:'5650'},
                
            ],
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            lclist: [
                { id: 1, name: '模板1' },
                { id: 2, name: '模板A' },
                { id: 3, name: '模板C' },
            ],
            selectedValue: null,
            fileList: [{ name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' },
            { name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }]

        }
    },
    methods: {
        onSubmit() { },
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handlePreview(file) {
            console.log(file);
        },
        handleExceed(files, fileList) {
            this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
        },
        beforeRemove(file, fileList) {
            return this.$confirm(`确定移除 ${file.name}？`);
        },
        toDetail(url) {
            window.open(url, '_blank')
        },
        toDetail() {
            this.$router.push('/trial/listDetail')
        }
    }
}
</script>

<style scoped lang="scss">
.contain {
    padding: 10px 30px;
}
.personlist{
    display: grid;
    grid-template-columns: repeat(3,1fr);
   
}
.personlist div{
    padding: 10px 0 ;
}

.header {

    display: grid;
    grid-template-columns: auto 1fr;
    margin-bottom: 10px;
    margin-top: 10px;

    .serachModel {
        display: grid;
        grid-template-columns: auto auto auto auto auto;
        gap: 10px;
    }

}

.file {
    display: grid;
    grid-template-columns: 1fr 1fr;
}
.twoModel {
        background-color: #eee;
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 10px;

        .twoitem {
            padding: 10px 0;
            // color: red;
        }

    }
    .newadd {
    display: grid;
    grid-template-columns: 1fr auto;
    border-bottom:  1px solid #c0bebe;
}
</style>