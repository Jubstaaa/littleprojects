package ınsann;

public class Insann {
private enum tur{özel,genel;}   
private String ad;
private Insann[] genel;
private Insann[] özel;
private String mesaj;
private String mesajAdet[];
    
public Insann(String ad) {
this.ad = ad;
}

public void arkadaslik_kur(Insann kisi) {
    int bırak=0;
for(int x=0;x<genel.length;x++){
if(genel[x] == kisi){bırak=1;}}
 if(bırak==0){
this.genel[genel.length+1] = kisi;
this.mesajAdet[genel.length+1] ="";}
else if(bırak==1){
}}

public void ekleOzel(Insann kisi) {
   int bırak=0;
for(int x=0;x<özel.length;x++){
if(özel[x] == kisi){bırak=1;}}
 if(bırak==0){
this.özel[özel.length+1] = kisi;}
else if(bırak==1){
}}

public void cikarOzel(Insann kisi) {
for(int x=0;x<özel.length;x++){
while(özel[x] == kisi){
    for(x=x;x<özel.length-1;x++)
özel[x] = özel[x+1];
}}}  

public void arkadaslik_bitir(Insann kisi) {
for(int x=0;x<özel.length;x++){
while(özel[x] == kisi){
    for(x=x;x<özel.length-1;x++){
özel[x] = özel[x+1];}}}
for(int x=0;x<genel.length;x++){
while(genel[x] == kisi){
    for(x=x;x<genel.length-1;x++){
genel[x] = genel[x+1];
mesajAdet[x] = mesajAdet[x+1];
 }}}}

public void gonderMesaj(tur tip, String mesaj){
    if(tip == tur.genel){
        for(int x=0;x<genel.length;x++){
            mesajAdet[x]+=  mesaj;}}
    else{
        for(int x=0;x<özel.length;x++){
            for(int y=0;y<genel.length;y++){
            while(özel[x]==genel[y])
            mesajAdet[y]+=  mesaj;}
    }}}

public void gonderMesaj(Insann kisi, String mesaj){
    for(int x=0;x<genel.length;x++){
while(genel[x] == kisi){
      mesajAdet[x]+=  mesaj;
    }}}

public void haykir(tur tip, String mesaj){
    mesaj=mesaj.toUpperCase();
    if(tip == tur.genel){
        for(int x=0;x<genel.length;x++)
            mesajAdet[x]+=  mesaj;}
    else{
        for(int x=0;x<özel.length;x++){
            for(int y=0;y<genel.length;y++){
            while(özel[x]==genel[y])
            mesajAdet[y]+=  mesaj;}
    }}}

public void haykir(Insann kisi, String mesaj){
    mesaj=mesaj.toUpperCase();
    for(int x=0;x<genel.length;x++){
while(genel[x] == kisi){
      mesajAdet[x]+=  mesaj;
    }}}

public void mesajAl(Insann kimden, String mesaj){
    for(int x=0;x<genel.length;x++){
while(genel[x] == kimden){
      mesajAdet[x]+=  mesaj;
    }}}

public void enSamimi(){
   int skor[]={0};
    for(int x=0;x<mesajAdet.length;x++){
       for(int i=0;i<mesajAdet[x].length()-1;i++){
        if(mesajAdet[x].charAt(i) == ' '){
            if(mesajAdet[x].charAt(i+1) == ' '){
                skor[x]+=skor[x];            }
            else{}}
            else{}
        }   
}
int enbuyuk = skor[0];
for(int y=1;y<skor.length;y++){
    if(skor[y]>enbuyuk){
        enbuyuk=skor[y];
    }
}
for(int z=0;z<genel.length;z++){
    while(skor[z]==enbuyuk){
        System.out.println("En çok görüşülen kişi"+ genel[z]);
         }
    
}
}

public void enSeyrek(){
   int skor[]={0};
    for(int x=0;x<mesajAdet.length;x++){
       for(int i=0;i<mesajAdet[x].length()-1;i++){
        if(mesajAdet[x].charAt(i) == ' '){
            if(mesajAdet[x].charAt(i+1) == ' '){
                skor[x]+=skor[x];            }
            else{}}
            else{}
        }   
}
int enkucuk = skor[0];
for(int y=1;y<skor.length;y++){
    if(skor[y]<enkucuk){
        enkucuk=skor[y];
    }
}
for(int z=0;z<genel.length;z++){
    while(skor[z]==enkucuk  ){
        System.out.println("En az görüşülen kişi"+ genel[z]);
         }
    
}
}

public void sifirlaMesaj(){
     for(int x=0;x<mesajAdet.length;x++){
         mesajAdet[x]="";
     }
    
}

public void unutGitsin(){
    for(int x=0;x<genel.length;x++){
       genel[x] = genel[x+1];
       mesajAdet[x] = mesajAdet[x+1];
       for(int y=0;y<özel.length;y++){
           özel[y] = özel[y+1];
       }
        
    }
}

public void herkeseEsitim(){
    for(int x=0;x<özel.length;x++){
           özel[x] = özel[x+1];
       }
}
public static void main(String[] args) {
    
    }
    
}
