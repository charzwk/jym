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
            <el-table-column prop="name" label="材料">
            </el-table-column>
            <el-table-column prop="price" label="单价">
            </el-table-column>
            <el-table-column prop="num" label="数量">
            </el-table-column>
            <el-table-column prop="proname" label="项目名称">
            </el-table-column>
            <el-table-column prop="rate" label="分配率">
            </el-table-column>
            <el-table-column prop="acount" label="金额">
            </el-table-column>
            <el-table-column prop="" label="操作">
                <template slot-scope="scope">
                    <!-- <el-button @click="toDetail">查看</el-button> -->
                    <el-button @click="dialogvisbel = true" type="primary">编辑</el-button>
                    <!-- <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button> -->
                </template>
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

                    <el-form-item label="日期">
                        <el-date-picker v-model="form.info2" type="datetime" placeholder="请选择日期"
                                style="width: 400px;">
                            </el-date-picker>
                    </el-form-item>
                    <el-form-item label="材料">
                        <el-select v-model="form.info3" placeholder="请选择材料">
                            <el-option v-for="item in phaseslist" :label="item.name" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="价格">
                        <el-input v-model="form.info11" type="text" placeholder="请输入价格"></el-input>
                    </el-form-item>
                    <el-form-item label="单价">
                        <el-input v-model="form.info11" type="text" placeholder="请输入单价"></el-input>
                    </el-form-item>
                    <el-form-item label="数量">
                        <el-input v-model="form.info11" type="text" placeholder="请输入数量"></el-input>
                    </el-form-item>
                    <el-form-item label="项目名称">
                        <el-input v-model="form.info11" type="text" placeholder="请输入项目名称"></el-input>
                    </el-form-item>
                    <el-form-item label="分配率">
                        <el-input v-model="form.info11" type="text" placeholder="请输入分配率"></el-input>
                    </el-form-item>

                    <el-form-item label="金额">
                        <el-input v-model="form.info11" type="text" placeholder="金额" disabled="true"></el-input>
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
                { year: '22024-10', name: '材料A', price:'100',num:'10',proname:'项目AC',rate:'100%',acount:'1000' },
                { year: '22024-10', name: '材料A', price:'100',num:'10',proname:'项目C',rate:'100%',acount:'1000' },
                { year: '22024-10', name: '材料A', price:'100',num:'10',proname:'项目d',rate:'100%',acount:'1000' },
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