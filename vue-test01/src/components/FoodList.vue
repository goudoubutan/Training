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
          <span style="margin-left: 10px">{{ scope.row.fid }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="名称"
        width="180">
        <template slot-scope="scope">
          <!-- <i class="el-icon-time"></i> -->
          <span style="margin-left: 10px;">{{ scope.row.fname }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="生产时间"
        width="180">
        <template slot-scope="scope">
          <!-- <i class="el-icon-time"></i> -->
          <span style="margin-left: 10px">{{ formatDate(scope.row.fcreated) }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="价格"
        width="180">
        <template slot-scope="scope">
          <!-- <i class="el-icon-time"></i> -->
          <span style="margin-left: 10px;">{{ scope.row.fprice }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="类型"
        width="180">
        <template slot-scope="scope">
          <!-- <i class="el-icon-time"></i> -->
          <span style="margin-left: 10px;">{{ scope.row.typename }}</span>
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
            @click="handleDelete(scope.row.fid)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>


    <!-- 编辑弹窗 -->
    <el-dialog :visible="showEdit" title="编辑页面" :append-to-body="true" :style="{ 'z-index': 9999 }">
      <!-- 编辑表单 -->
      <el-form :model="editedItem" label-width="80px">

        <el-form-item label="名称">
          <el-input v-model="editedItem.fname"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model="editedItem.fprice"></el-input>
        </el-form-item>
        <el-form-item label="生产日期">
          <el-date-picker v-model="editedItem.fcreated" type="date" placeholder="选择日期">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="类型">
          <el-select v-model="selectOptions" placeholder="请选择">
            <!-- 使用 v-for 渲染选项 -->
            <el-option v-for="option in types" :key="option.tid" :value="option.tid" :label="option.tname"></el-option>
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

      <el-form :model="editedItem" label-width="80px">
      <el-form-item label="名称">
        <el-input v-model="addItem.fname"></el-input>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="addItem.fprice"></el-input>
      </el-form-item>
      <el-form-item label="生产日期">
        <el-date-picker v-model="addItem.fcreated" type="date" placeholder="选择日期">
        </el-date-picker>
      </el-form-item>

      <el-form-item label="类型">
        <el-select v-model="selectOptions" placeholder="请选择">
          <!-- 使用 v-for 渲染选项 -->
          <el-option v-for="option in types" :key="option.tid" :value="option.tid" :label="option.tname"></el-option>
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

import {getFoodList,updFoodById,delFoodById,addFood,getTypes} from '../api/food.js'
export default {
  data() {
    return {
      tableData: [
        {
          fid: '',
          fname: '',
          fprice: '',
          fcreated:'',
          typename:''
        }
      ],
      showEdit: false,
      showAdd:false,
      editedItem: {
        fid: '',
        fname: '',
        fprice: '',
        fcreated:'',
        tid:''
      },
      addItem: {
        fname: '',
        fprice: '',
        fcreated:'',
        tid:''
      },
      selectOptions:'',
      types:[]
    }

  },
  methods: {
    fechData(){
      getFoodList().then(res => {
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
      this.editedItem.fid = row.fid;
      this.editedItem.fname = row.fname;
      this.editedItem.fprice = row.fprice;
      this.editedItem.fcreated = row.fcreated;
      this.showEdit = true;

      getTypes().then(res => {
        this.types = res.data.data;
        this.selectOptions = this.editedItem.type;
      })
    },
    add() {
      this.showAdd = true;
      getTypes().then(res => {
        this.types = res.data.data;
      })
    },
    handleDelete(fid) {
      delFoodById(fid).then(res => {
        this.$message({
          title: '提示',
          message: '删除成功',
          type: 'success'
        });
        this.fechData();
      })
    },

    saveEditedItem() {
      this.editedItem.tid = this.selectOptions;
      updFoodById(this.editedItem.fid,this.editedItem).then(res => {
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
      this.addItem.tid = this.selectOptions;
      addFood(this.addItem).then(res => {
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
