const express = require('express');
const http = require('http');
const socketIo = require('socket.io');

const app = express();
const server = http.createServer(app);
const io = socketIo(server);

app.use(express.json());

let onlineUsers = new Set(); // 存储在线用户的集合

io.on('connection', (socket) => {
  const userId = socket.handshake.query.userId;
  if (userId) {
    onlineUsers.add(userId);
  }

  socket.on('disconnect', () => {
    if (userId) {
      onlineUsers.delete(userId);
    }
  });

  socket.on('submitInfo', (data) => {
    const { info, approverId } = data;

    // 模拟保存信息到数据库
    console.log(`信息提交成功: ${info}, 审批人: ${approverId}`);

    // 检查审批人B的在线状态
    if (onlineUsers.has(approverId)) {
      io.to(approverId).emit('notify', `用户A已提交信息: ${info}`);
    }
  });
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});