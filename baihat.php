<?php
   require"connect.php";
   class Baihat{
   	  function Baihat($idbaihat,$tenbaihat,$hinhbaihat,$casi,$linkbaihat,$luotthich){
   	  	$this->Idbaihat=$idbaihat;
   	  	$this->Tenbaihat=$tenbaihat;
   	  	$this->Hinhbaihat=$hinhbaihat;
   	  	$this->Luotthich=$luotthich;
   	  	$this->Casi=$casi;
   	  	$this->Linkbaihat=$linkbaihat;
   	  }
   }
   $arraybaihat=array();
   
   if(isset($_POST['idalbum'])){
        $idalbum=$_POST['idalbum'];
   $query="SELECT * FROM baihat WHERE FIND_IN_SET('$idalbum',idAlbum)";
   }
   
   
   $query="SELECT * FROM baihat";
   $data=mysqli_query($con,$query);
   while($row=mysqli_fetch_assoc($data)){
   	array_push($arraybaihat,new Baihat($row['idBaiHat']
                                     ,$row['TenBaiHat']
                                     ,$row['HinhBaiHat']
                                     ,$row['Casi']
                                     ,$row['LinkBaiHat']
                                     ,$row['LuotThich']));
   }
   echo json_encode($arraybaihat);
?>