/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Main
{
public static void main(String args[]) {
ArrayList<Character> L = new ArrayList<Character>();
ArrayList<Character> F = new ArrayList<Character>();
ArrayList<Character> S = new ArrayList<Character>();
ArrayList<Character> Sh = new ArrayList<Character>();
int correctchoice=0;
System.out.println("Enter the number of the required process:\n1-Encrypt A message\n2-Decrept a message\n3-Exit\n");
Scanner input = new Scanner(System.in);
while(correctchoice!=3){
int process=input.nextInt();
switch(process){
    case 1: correctchoice=1;EncriptMsg(L,F,S,Sh);break;
    case 2:correctchoice=2;DecriptMsg(L,F,S,Sh);break;
    case 3:correctchoice=3;System.exit(0);
    default:System.out.println("Enter a valid number");break;
       
}
System.out.println("Enter the number of the required process:\n1-Encrypt A message\n2-Decrept a message\n3-Exit\n ");
}

}

public static void PrepareGroups(int partitionkey,int shiftKey,ArrayList<Character> L,ArrayList<Character> F,ArrayList<Character> S,ArrayList<Character> Sh){
    L.clear();
    F.clear();
    S.clear();
    Sh.clear();
char[] alphabatic = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
int i=0;
while(i<26){
for(int l=0; l<partitionkey;++l){
if(i<26){
    L.add(alphabatic[i]);
    ++i;
}
else
break;
}
for(int f=0;f<partitionkey;++f) {
if(i<26){
    F.add(alphabatic[i]);
    ++i;
}
else
break;
}
for(int s=0; s<partitionkey;++s){
if(i<26){
    S.add(alphabatic[i]);
    ++i;
}
else
break;
}
for(int sh=0;sh<partitionkey;++sh) {
if(i<26){
    Sh.add(alphabatic[i]);
    ++i;
}
else
break;
}
}
Collections.rotate( L, shiftKey);
Collections.rotate( F, shiftKey);
Collections.rotate( S, shiftKey);
Collections.rotate( Sh, shiftKey);
System.out.println(L);
System.out.println(F);
System.out.println(S);
System.out.println(Sh);
}    
public static void EncriptMsg(ArrayList<Character> l,ArrayList<Character> f,ArrayList<Character> s,ArrayList<Character> sh){
    Scanner input = new Scanner(System.in);
System.out.println("Enter your partitioning key = ");
int PartKey=input.nextInt();
System.out.println("Enter your shifting key = ");
int ShiftKey=input.nextInt();
PrepareGroups(PartKey,ShiftKey,l,f,s,sh);
//System.out.println("Enter your Message = ");
//String msg=input.nextLine();  
String msg="waad";
msg=msg.toUpperCase();

   
    String encreptedMSG="";
   
    for (char letter: msg.toCharArray()) {
        if(l.indexOf(letter)!=-1){
            encreptedMSG+=String.format("L%02d",l.indexOf(letter)+PartKey);
        }
        else if(f.indexOf(letter)!=-1){
            encreptedMSG+=String.format("F%02d",f.indexOf(letter)+PartKey);
        }
        else if(s.indexOf(letter)!=-1){
            encreptedMSG+=String.format("S%02d",s.indexOf(letter)+PartKey);
        }
        else if(sh.indexOf(letter)!=-1){
            encreptedMSG+=String.format("$%02d",sh.indexOf(letter)+PartKey);
        }
}
System.out.printf("Your message \"%s\" after encription is: \n%s\n",msg , encreptedMSG);
}
public static void DecriptMsg(ArrayList<Character> l,ArrayList<Character> f,ArrayList<Character> s,ArrayList<Character> sh){
     Scanner input = new Scanner(System.in);
System.out.println("Enter the partitioning key = ");
int PartKey=input.nextInt();
System.out.println("Enter the shifting key = ");
int ShiftKey=input.nextInt();
PrepareGroups(PartKey,ShiftKey,l,f,s,sh);
//System.out.println("Enter your Message = ");
//String msg=input.nextLine();  
String msg="S06S04L09S04L09F03F05F04S04F04S05F03";
   
    String DecriptedMsg="";
   for (int i=0; i<msg.length();++i) {
       char group= msg.charAt(i);
       int position;
       switch(group){
           case 'L':position= 10*Character.getNumericValue(msg.charAt(i+1))+Character.getNumericValue(msg.charAt(i+2))-PartKey;DecriptedMsg+=l.get(position);break;
           case 'F':position= 10*Character.getNumericValue(msg.charAt(i+1))+Character.getNumericValue(msg.charAt(i+2))-PartKey;DecriptedMsg+=f.get(position);break;
           case 'S':position= 10*Character.getNumericValue(msg.charAt(i+1))+Character.getNumericValue(msg.charAt(i+2))-PartKey;DecriptedMsg+=s.get(position);break;
           case '$':position= 10*Character.getNumericValue(msg.charAt(i+1))+Character.getNumericValue(msg.charAt(i+2))-PartKey;DecriptedMsg+=sh.get(position);break;
           default:break;
       }


}System.out.printf("Your message \"%s\" after decription is: \n%s\n",msg , DecriptedMsg);}}
