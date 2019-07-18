package disk;

public class Disk {
private String label;
private int bytePerSector;
private int sectorPerCluster;
private int clusterPerTrack;
private int trackPerSide;
private int sidePerPlate;
private int numberOfPlate; 
private int rpm;
private int placeHeadTrack;
private int placeHeadCluster;
private int timeJumpTrack;
private int timeRead;

public Disk(String label, int bytePerSector, int sectorPerCluster, int clusterPerTrack, int trackPerSide, int sidePerPlate, int numberOfPlate, int rpm, int placeHeadTrack, int placeHeadCluster, int timeJumpTrack, int timeRead) {
this.label = label;
this.bytePerSector = bytePerSector;
this.sectorPerCluster = sectorPerCluster;
this.clusterPerTrack = clusterPerTrack;
this.trackPerSide = trackPerSide;
this.sidePerPlate = sidePerPlate;
this.numberOfPlate = numberOfPlate;
this.rpm = rpm;
this.placeHeadTrack = placeHeadTrack;
this.placeHeadCluster = placeHeadCluster;
this.timeJumpTrack = timeJumpTrack;
this.timeRead = timeRead;
}

public boolean locateHead(int track, int cluster){
   boolean sonuc;
    if(this.placeHeadTrack==track && this.placeHeadCluster==cluster){
        sonuc=false;
    }
    else{
        this.placeHeadTrack=track;
        this.placeHeadCluster=cluster;
        sonuc=true;
    }   
       return sonuc;
}

public void sayCapacity(){
   int Sonuc=bytePerSector*sectorPerCluster*clusterPerTrack*trackPerSide*sidePerPlate*numberOfPlate;
   System.out.println("Capacity of Disk is "+Sonuc+" byte");
}

public void sayTrackCapacity(){
   int Sonuc=this.bytePerSector*this.sectorPerCluster*this.clusterPerTrack;
   System.out.println("Capacity of Track is "+Sonuc+" byte");
}

public void sayClusterCapacity(){
   int Sonuc=this.bytePerSector*this.sectorPerCluster;
   System.out.println("Capacity of Cluster is "+Sonuc+" byte");
}

public void saySideCapacity(){
   int Sonuc=this.bytePerSector*this.sectorPerCluster*this.clusterPerTrack*this.trackPerSide;
   System.out.println("Capacity of Side is "+Sonuc+" byte");
}

public void saySectorPerTrack(){
   int Sonuc=this.sectorPerCluster*this.clusterPerTrack;
   System.out.println("Sector Per Track is "+Sonuc);
}

public void saySectorPerSide(){
   int Sonuc=this.sectorPerCluster*this.clusterPerTrack*this.trackPerSide;
   System.out.println("Sector Per Side is "+Sonuc);
}

public void sayClusterPerSide(){
   int Sonuc=this.clusterPerTrack*this.trackPerSide;
   System.out.println("Cluster Per Side is "+Sonuc);
}

public void sayTotalSector(){
   int Sonuc=this.sectorPerCluster*this.clusterPerTrack*this.trackPerSide*this.sidePerPlate*this.numberOfPlate;
   System.out.println("Total Sector of Disk is "+Sonuc);
}

public void sayTotalCluster(){
   int Sonuc=this.clusterPerTrack*this.trackPerSide*this.sidePerPlate*this.numberOfPlate;
   System.out.println("Total Cluster of Disk is "+Sonuc);
}

public void sayTotalTrack(){
   int Sonuc=this.trackPerSide*this.sidePerPlate*this.numberOfPlate;
   System.out.println("Total Track of Disk is "+Sonuc);
}

public void sayTimePerCluster(){
   int Sonuc=(1/(rpm/60))/this.clusterPerTrack;
   System.out.println("Time Per Cluster is "+Sonuc+" second.");
}

public void sayHowFarCluster(int cluNo){
  int Sonuc=cluNo-this.placeHeadCluster;
  if(Sonuc<0){
      Sonuc=Sonuc+((-2)*Sonuc);}
   System.out.println(Sonuc+" Cluster Need To Reach.");
}

public void sayHowFarTrack(int trackNo){
  int Sonuc=trackNo-this.placeHeadTrack;
  if(Sonuc<0){
      Sonuc=Sonuc+((-2)*Sonuc);}
   System.out.println(Sonuc+" Track Need To Reach.");
}

public void sayAccessTime(int track, int cluster){
  int Sonuc1=track-this.placeHeadTrack;
  if(Sonuc1<0){
      Sonuc1=Sonuc1+((-2)*Sonuc1);}
  Sonuc1=Sonuc1*this.timeJumpTrack;
  int Sonuc2=cluster-this.placeHeadCluster;
  if(Sonuc2<0){
      Sonuc2=Sonuc2+((-2)*Sonuc2);}
 Sonuc2=Sonuc2*(1/(rpm/60))/this.clusterPerTrack;
 int Sonuc=Sonuc1+Sonuc2+this.timeRead;
   System.out.println(Sonuc+"ms Need To Read.");
}

public void sayLogicalClusterNo(int track, int cluster  ){
  int Sonuc=(this.clusterPerTrack*track-1)+cluster;
   System.out.println("Logical Cluster Number is "+Sonuc);
}

//public void sayLogicalSectorNo(int track, int cluster, int sector){
 // int Sonuc=
  // System.out.println("Logical Cluster is "+Sonuc);
//}

public void sayHowManyCluster(int fileSize){
 double Sonuc=(double)fileSize/(double)(this.bytePerSector*this.sectorPerCluster);
 if((int)Sonuc!=(double)Sonuc){
      Sonuc=Sonuc+1;
 }
 Sonuc=(int)Sonuc;
   System.out.println(Sonuc+" Cluster Used.");
}

public void sayFileSizeOnDisk(int fileSize){
 double Sonuc=(double)fileSize/(double)(this.bytePerSector*this.sectorPerCluster);
 if((int)Sonuc!=(double)Sonuc){
      Sonuc=Sonuc+1;
      }
 Sonuc=(int)Sonuc;
 Sonuc=this.bytePerSector*this.sectorPerCluster*Sonuc;
   System.out.println(Sonuc+" Space Used on Disk");
}

public void sayFileWastingOnDisk(int fileSize){
 double Sonuc=(double)fileSize/(double)(this.bytePerSector*this.sectorPerCluster);
 if((int)Sonuc!=(double)Sonuc){
      Sonuc=Sonuc+1;
      }
 Sonuc=(int)Sonuc;
 Sonuc=(this.bytePerSector*this.sectorPerCluster*Sonuc)-fileSize;
   System.out.println(Sonuc+" Space Wasted on Disk");
}

public void sayTimeToStartMusic(int logicalCluNo){
 int track=(logicalCluNo/this.clusterPerTrack)+1;
 int clu=(logicalCluNo%this.clusterPerTrack);
 
 int Sonuc1=track-this.placeHeadTrack;
  if(Sonuc1<0){
      Sonuc1=Sonuc1+((-2)*Sonuc1);}
  Sonuc1=Sonuc1*this.timeJumpTrack;
  int Sonuc2=clu-this.placeHeadCluster;
  if(Sonuc2<0){
      Sonuc2=Sonuc2+((-2)*Sonuc2);}
 Sonuc2=Sonuc2*(1/(rpm/60))/this.clusterPerTrack;
 int Sonuc=Sonuc1+Sonuc2+this.timeRead;
   System.out.println("Music Will Start "+Sonuc+"ms After.");
}
public static void main(String[] args) {
       
    }
    
}
