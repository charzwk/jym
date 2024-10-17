<template>
    <div class="contain">
        <!-- header -->
        <div class="header">
            <el-button style="color: white;background-color: #2468f2;" @click="dialogvisbel = true">新增</el-button>
            <div class="serachModel">
                <div> <el-input placeholder="请输入内容" suffix-icon="el-icon-search" v-model="input1">
                    </el-input></div>
            </div>
        </div>
        <!-- table -->
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="name" label="项目名称">
            </el-table-column>
            <el-table-column prop="target" label="项目目标">
            </el-table-column>
            <el-table-column prop="decompose" label="研究内容分解">
            </el-table-column>
            <el-table-column prop="demand" label="设备需求">
            </el-table-column>

            <el-table-column prop="name" label="操作">
                <template slot-scope="scope">

                    <el-button @click="toDetail">查看</el-button>
                    <el-button @click="dialogvisbel = true" type="primary">编辑</el-button>
                    <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button>
                </template>
            </el-table-column>

        </el-table>
        <!-- 分页 -->
        <el-pagination style="margin: 20px 0 ;" background layout="prev, pager, next" :total="1000">
        </el-pagination>

        <!-- 弹框 -->
        <el-dialog title="项目申报" :visible.sync="dialogvisbel" width="50%">

            <el-form ref="form" :model="form" label-width="100px">
                <!-- 第一步 项目信息 -->
                <div>
                    <el-form-item label="项目名称">
                        <el-input v-model="form.info11" type="text" :rows="4" placeholder="请输入项目名称"></el-input>
                    </el-form-item>



                    <el-form-item label="项目目标">
                        <el-input v-model="form.info1" type="textarea" :rows="4" placeholder="请输入项目目标"></el-input>
                    </el-form-item>

                    <el-form-item label="研究内容分解">
                        <el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入调研内容"></el-input>
                    </el-form-item>

                    <el-form-item label="设备需求">
                        <el-input v-model="form.info2" type="textarea" :rows="4" placeholder="请输入设备需求"></el-input>
                    </el-form-item>

                    <el-form-item label="人员配置">
                        <el-button type="primary">新增人员</el-button>
                        <el-table :data="tableData" style="width: 100%">
                            <el-table-column prop="name" label="姓名">
                            </el-table-column>
                            <el-table-column prop="target" label="角色">
                            </el-table-column>
                            <el-table-column prop="target" label="备注">
                            </el-table-column>
                            <el-table-column prop="name" label="操作">
                                <template slot-scope="scope">
                                    <el-button @click="dialogvisbel = true" type="primary">编辑</el-button>
                                    <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button>
                                </template>
                            </el-table-column>

                        </el-table>
                    </el-form-item>

                    <el-form-item label="设备清单">
                        <el-button type="primary">新增设备</el-button>
                        <el-table :data="tableData" style="width: 100%">
                            <el-table-column prop="name" label="设备名称">
                            </el-table-column>
                            <el-table-column prop="target" label="花费">
                            </el-table-column>
                            <el-table-column prop="target" label="备注">
                            </el-table-column>
                            <el-table-column prop="name" label="操作">
                                <template slot-scope="scope">
                                    <el-button @click="dialogvisbel = true" type="primary">编辑</el-button>
                                    <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button>
                                </template>
                            </el-table-column>

                        </el-table>
                    </el-form-item>

                    <el-form-item label="投入费用计划">
                        <el-button type="primary">新增</el-button>
                        <el-table :data="tableData" style="width: 100%">
                            <el-table-column prop="name" label="费用姓项">
                            </el-table-column>
                            <el-table-column prop="target" label="费用金额">
                            </el-table-column>
                            <el-table-column prop="target" label="备注">
                            </el-table-column>
                            <el-table-column prop="name" label="操作">
                                <template slot-scope="scope">
                                    <el-button @click="dialogvisbel = true" type="primary">编辑</el-button>
                                    <el-button @click="deleteRow(scope.row)" type="danger">删除</el-button>
                                </template>
                            </el-table-column>

                        </el-table>
                    </el-form-item>









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
                { name: '基哥项目调研报告', target: 'xxxxx', decompose: '1,xxxxxx,2xxxx,3xxx', demand: '内存必须大于32' }

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
            this.$router.push('/project/projectDetail')
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
        justify-self: end;
    }

}

.file {
    display: grid;
    grid-template-columns: 1fr 1fr;
}
</style>