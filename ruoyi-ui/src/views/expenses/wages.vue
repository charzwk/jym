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
                <div class="topinput">
                    人员: <el-select v-model="form.info3" placeholder="请选择人员">
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
            <el-table-column prop="year" label="年月">
            </el-table-column>
            <el-table-column prop="name" label="姓名">
            </el-table-column>
            <el-table-column prop="roles" label="角色">
            </el-table-column>
            <el-table-column prop="dep" label="部门">
            </el-table-column>
            <el-table-column prop="hour1" label="应出勤小时">
            </el-table-column>
            <el-table-column prop="hour2" label="实际出勤小时">
            </el-table-column>
            <!-- <el-table-column prop="wu1" label="养老">
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
            </el-table-column> -->
            <el-table-column prop="projectname" label="项目名称">
            </el-table-column>
            <el-table-column prop="rate" label="分配率">
            </el-table-column>
            <el-table-column prop="projectwages" label="项目工资">
            </el-table-column>
            <el-table-column prop="pigeonhole" label="归档">
            </el-table-column>
            <el-table-column prop="totalCost" label="总工资">
            </el-table-column>
            <el-table-column prop="isZX" label="是否专项">
            </el-table-column>

        </el-table>
        <!-- 分页 -->
        <el-pagination style="margin: 20px 0 ;" background layout="prev, pager, next" :total="1000">
        </el-pagination>

        <!-- 弹框 -->
        <el-dialog title="新增表" :visible.sync="dialogvisbel" width="50%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- 第一步 项目信息 -->
                <div>

                    <el-form-item label="表名">
                        <el-select v-model="form.info3" placeholder="请选择项目">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="发起人">
                        <el-select v-model="form.info3" placeholder="请选择发起人">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="发起时间">
                        <el-date-picker v-model="form.info2" type="datetime" placeholder="请选择发起时间"
                            style="width: 400px;">
                        </el-date-picker>

                    </el-form-item>

                    <el-form-item label="备注">
                        <el-input v-model="form.info11" type="text" placeholder="请输入备注"></el-input>
                    </el-form-item>


                    <!-- <el-form-item label="创建时间">
                        <el-date-picker v-model="dateRange" type="datetime"  placeholder="请选择时间"
                             style="width: 400px;">
                        </el-date-picker>
                    </el-form-item> -->
                </div>


                <el-form-item>
                    <div class="form-buttons">
                        <el-button type="primary" @click="onSubmit">保存</el-button>
                        <el-button @click="dialogvisbel = false">取消</el-button>
                    </div>
                </el-form-item>
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
                { year: '22024-10', name: '张三', roles: '开发', dep: '部门', hour1: '15',
                 hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                 projectwages: '1200', pigeonhole: 'xx',totalCost:'50000' ,isZX:'是'},
                 { year: '22024-10', name: '张三', roles: '开发', dep: '部门', hour1: '15',
                 hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                 projectwages: '1200', pigeonhole: 'xx' ,totalCost:'50000' ,isZX:'否'},
                 { year: '22024-10', name: '张三', roles: '开发', dep: '部门', hour1: '15',
                 hour2: '15', wu1:'100',wu2:'100',wu3:'100',wu4:'100',wu5:'100',wu6:'100', projectname: '项目1', rate: '100%', 
                 projectwages: '1200', pigeonhole: 'xx',totalCost:'50000',isZX:'是' },
                
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
</style>