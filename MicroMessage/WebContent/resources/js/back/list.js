/**
 * 调用后台批量删除
 */

function deleteBatch(basePath) {
	$("#mainForm").attr("action", basePath+"/DeleteBatchServlet.action");
	$("#mainForm").submit();
}