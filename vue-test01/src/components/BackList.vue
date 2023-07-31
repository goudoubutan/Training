<template>
  <div>
    <h1>{{this.$route.query.user}}</h1>
    <el-button type="primary" @click="add()">添加</el-button>
    <el-table
      :data="tableData"
      class="tables">

      <el-table-column
        label="编号"
        width="180">
        <template slot-scope="scope">
          <!-- <i class="el-icon-time"></i> -->
          <span style="margin-left: 10px">{{ scope.row.id }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="电话"
        width="180">
        <template slot-scope="scope">
          <!-- <i class="el-icon-time"></i> -->
          <span style="margin-left: 10px;">{{ scope.row.tel }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="呼叫时间"
        width="180">
        <template slot-scope="scope">
          <!-- <i class="el-icon-time"></i> -->
          <span style="margin-left: 10px">{{ formatDate(scope.row.created) }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="用户反馈"
        width="180">
        <template slot-scope="scope">
          <!-- <i class="el-icon-time"></i> -->
          <span style="margin-left: 10px;">{{ scope.row.content }}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>


    <!-- 编辑弹窗 -->
    <el-dialog :visible="showEdit" title="编辑页面" :append-to-body="true" :style="{ 'z-index': 9999 }">
      <!-- 编辑表单 -->
      <el-form :model="editedItem" label-width="80px">
        <el-form-item label="来电">
          <el-input v-model="editedItem.tel"></el-input>
        </el-form-item>
        <el-form-item label="时间">
          <el-date-picker v-model="editedItem.created" type="date" placeholder="选择日期">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="满意度">
          <el-select v-model="selectOptions" placeholder="请选择">
            <!-- 使用 v-for 渲染选项 -->
            <el-option v-for="option in manyidu" :key="option.id" :value="option.id" :label="option.content"></el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <div slot="footer">
        <el-button @click="showEdit = false">取消</el-button>
        <el-button type="primary" @click="saveEditedItem">保存</el-button>
      </div>
    </el-dialog>

    <!-- 新增弹窗 -->
    <el-dialog :visible="showAdd" title="新增页面" :append-to-body="true" :style="{ 'z-index': 9999 }">
      <!-- 编辑表单 -->
      <el-form :model="addItem" label-width="80px">
        <el-form-item label="来电">
          <el-input v-model="addItem.tel"></el-input>
        </el-form-item>
        <el-form-item label="时间">
          <el-date-picker v-model="addItem.created" type="date" placeholder="选择日期">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="满意度">
          <el-select v-model="selectOptions" placeholder="请选择">
            <!-- 使用 v-for 渲染选项 -->
            <el-option v-for="option in manyidu" :key="option.id" :value="option.id" :label="option.content"></el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <div slot="footer">
        <el-button @click="showAdd = false">取消</el-button>
        <el-button type="primary" @click="addItemed">保存</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>

import {getBackList,updBackById,getManYiDu,delBackById,addBack} from '../api/back.js'
export default {
  data() {
    return {
      tableData: [
        {
          id: '',
          tel: '',
          created: '',
          content:'',
        }
      ],
      showEdit: false,
      showAdd:false,
      editedItem: {
        id: '',
        tel: '',
        created: '',
        backid:''
      },
      addItem: {
        id: '',
        tel: '',
        created: '',
        backid:''
      },
      selectOptions:'',
      manyidu:[]
    }

  },
  methods: {
    fechData(){
      getBackList().then(res => {
        this.tableData = res.data.data;
      });
    },
    formatDate(dateString) {
      const date = new Date(dateString);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, '0');
      const day = String(date.getDate()).padStart(2, '0');
      return `${year}年${month}月${day}日`;
    },
    handleEdit(row) {
      // this.editedItem = Object.assign({}, row);
      this.editedItem.id = row.id;
      this.editedItem.tel = row.tel;
      this.editedItem.created = row.created;
      // console.log(this.editedItem)
      this.showEdit = true;

      getManYiDu().then(res => {
        this.manyidu = res.data.data;
        this.selectOptions = this.editedItem.type;
      })
    },
    add() {
      this.showAdd = true;
      getManYiDu().then(res => {
        this.manyidu = res.data.data;
      })
    },
    handleDelete(id) {
      delBackById(id).then(res => {
        this.$message({
          title: '提示',
          message: '删除成功',
          type: 'success'
        });
        this.fechData();
      })
    },

    saveEditedItem() {
      this.editedItem.backid = this.selectOptions;
      updBackById(this.editedItem.id,this.editedItem).then(res => {
          // 重新加载页面
          this.fechData();
          this.$message({
            title: '提示',
            message: '修改成功',
            type: 'success'
          });
        })
      // 关闭编辑弹窗
      this.showEdit = false;
    },

    addItemed() {
      this.addItem.backid = this.selectOptions;
      addBack(this.addItem).then(res => {
        // 重新加载页面
        this.fechData();
        this.$message({
          title: '提示',
          message: '新增成功',
          type: 'success'
        });
      })
      // 关闭编辑弹窗
      this.showAdd = false;
    },
  },
  mounted(){
    this.fechData();
  }
}
</script>

<style>
.tables {
  margin-left: 240px;
  text-align: center;
}
</style>
