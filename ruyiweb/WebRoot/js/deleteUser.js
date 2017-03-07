function deleteUser(id){
 if(window.confirm('你确定要删除该账户吗？')){ 

	 location.href = "${pageContext.request.contextPath}/admin_deleteUser?id="+id;

}else{ 
//alert("取消"); 
    
} 
}