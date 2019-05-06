<?php
    include_once ('../../db.php');

    if(isset($_GET['oid'])){
        $oid=$_GET['oid'];
        $sql="UPDATE orders SET shipStatus='Shipped' WHERE orderId=$oid";
        $result=$conn->query($sql);
        if(!$sql){
            header('location: ../order.php?shipped=error');
        }else{
            header('location: ../order.php?shipped=success');
        }

    }

    if(isset($_GET['rid'])){
        $oid=$_GET['rid'];
        $sql="UPDATE orders SET orderReceive='Received' WHERE orderId=$oid";
        $result=$conn->query($sql);
        if(!$sql){
            header('location: ../purchased.php?received=error');
        }else{
            header('location: ../purchased.php?received=success');
        }

    }
?>