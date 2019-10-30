<?php
  require "connect.php";
  class Baihat
  {

  	function Baihat($idbaihat,$tenbaihat,$hinhbaihat,$casi,$linkbaihat,$luotthich)
  	{
             $this -> idbaihat = $idbaihat;
             $this -> tenbaihat = $tenbaihat;
             $this -> hinhbaihat= $hinhbaihat;
             $this -> casi = $casi;
             $this -> linkbaihat = $linkbaihat;
             $this -> luotthich = $luotthich;    
  	}
 }
	# code...    
 $arraycasi = array();
 $query ="SELECT * FROM baihat";
	$data = mysqli_query($con,$query);
	while($row = mysqli_fetch_assoc($data)) {
		array_push($arraycasi, new Baihat($row['idBaiHat']
	                                  ,$row['TenBaiHat']
	                                  ,$row['HinhBaiHat']
	                                  ,$row['Casi']
	                                  ,$row['LinkBaiHat']
	                                  ,$row['LuotThich']));
	}

 echo json_encode($arraycasi);
?>