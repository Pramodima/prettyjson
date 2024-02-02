<!DOCTYPE html>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<head>
  <style><%@include file="/WEB-INF/Views/css/base64.css"%></style>
  <style>body{background-color:#128FCB;button { width: 170px;height: 50px;font-size: 20px}</style>
</head>
<div class="page-content-wrapper">
	<div class="page-content">
		<div class="page-head">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h2>Minify(Compact) Json generator</h2>
			</div>
			<button  type="submit"  , onclick="window.location.href = 'minify'">Minify </button>
                        <button  type="submit"  , onclick="window.location.href = '/'">Beautify </button>
			<br></br></br></br>
			<!--<a href="encode" class=""><h3><a href="encode" rel="external"><i class=""></i>Encode</a></h3>
			<a href="/" class="active"><h3><a href="/" rel="external"><i class=""></i>Decode</a></h3> -->
			<!-- END PAGE TITLE -->
		</div>
		<!-- END PAGE HEAD -->

		<div class="portlet default no-space">
					<div class="portlet-body">
						<div class="row">
									<div class="col-md-4 pull-left">
										<div class="btn-group">

										<textarea name="input" id="beautified" placeholder="Type (or paste) here..." spellcheck="false" rows="20" cols="100"></textarea>

										<div style="float: center;padding: 17px;color: #000;position: relative;"><button type="submit" style="float:center;" id="clickAction" onclick="clickActions()">Click to Minify</a></div>
										</div>
								</div>


							</div>
							<!--/span-->
						</div>
				</div>
		<br clear="all"/>
 <div id="resultDiv">

        <textarea name="rdesc" id="rdesc"  rows="20" cols="100" required></textarea>
    </div>
<script type="text/javascript">
var clickActions = function() {
$("#rdesc").value='';

 var beautifiedStr = document.getElementById('beautified').value;
  if(beautifiedStr!=''){
  $.ajax({
    url: "/getMinifyJson",
           data : "beautifiedString="+encodeURIComponent(beautifiedStr),
    cache: false,
    success: function(html){

      $("#rdesc").val(html);
    },
    error: function (data) {

    }
  });
}
}
	</script
	<!-- END JAVASCRIPTS -->
