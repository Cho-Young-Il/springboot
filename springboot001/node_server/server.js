var express = require("express");
var mysql = require("mysql");
/* pool.js -> private infomations. ignore file */
var pInfo = require("./pool.js");
var pool = mysql.createPool({
	host : pInfo.host,
	port : pInfo.port,
	user : pInfo.user,
	password : pInfo.pwd,
	database : pInfo.database,
	connectionLimit : 20,
	waitForConnections : false
});

var app = express();
var http = require("http").Server(app);

app.get("/idCheck", function(req, res) {
	var callback = req.param("callback");
	var regex = /^[a-z]+[a-z0-9]{4,19}$/g;
	var mid = req.param("mid");
	if(!regex.test(mid)) {
		res.send(callback + "({'status' : 'invalid'})");
	} else {
		pool.getConnection(function(err, conn) {
			var query = "select count(*) cnt from member where mid='" + mid + "'"; 
			conn.query(query, function(err, rows, fields) {
				if(err) throw err;
				if(rows[0].cnt == 1) {
					res.send(callback+"({'status' : 'fail'})");
				}else {
					res.send(callback+"({'status' : 'ok'})");
				}
				conn.release();
			});
		});
	}
});

http.listen(10001, function() {
	console.log("Node server has been started on listening port 10001.");
});