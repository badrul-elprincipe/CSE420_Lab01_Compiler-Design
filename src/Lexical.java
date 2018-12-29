/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author 
 */
public class Lexical {

    static ArrayList <String> kw=new ArrayList<String>();
    static ArrayList <String> id=new ArrayList<String>();
    static ArrayList <String> mo=new ArrayList<String>();
    static ArrayList <String> lo=new ArrayList<String>();
    static ArrayList <String> num=new ArrayList<String>();
    static ArrayList <String> oth=new ArrayList<String>();
    
    static ArrayList <String> fkw=new ArrayList<String>();
    static ArrayList <String> fid=new ArrayList<String>();
    static ArrayList <String> fmo=new ArrayList<String>();
    static ArrayList <String> flo=new ArrayList<String>();
    static ArrayList <String> fnum=new ArrayList<String>();
    static ArrayList <String> foth=new ArrayList<String>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic
 
        
        //storing keywords
        FileReader f=new FileReader("keywords.txt");
        BufferedReader br=new BufferedReader(f);
        String s=br.readLine();
        kw.add(s);
        while((s=br.readLine())!=null)
        {
            //s=br.readLine();
            kw.add(s);
        }
        //System.out.println(kw);
        
        //storing math_operators
        FileReader f1=new FileReader("math_operators.txt");
        BufferedReader br1=new BufferedReader(f1);
        String s1=br1.readLine();
        mo.add(s1);
        while((s1=br1.readLine())!=null)
        {
            
            mo.add(s1);
        }
        //System.out.println(mo);
        
        //storing logical_operators
        FileReader f2=new FileReader("logical_operators.txt");
        BufferedReader br2=new BufferedReader(f2);
        String s2=br2.readLine();
        lo.add(s2);
        while((s2=br2.readLine())!=null)
        {
            
            lo.add(s2);
        }
        //System.out.println(lo);
        
        //storing others
        FileReader f3=new FileReader("others.txt");
        BufferedReader br3=new BufferedReader(f3);
        String s3=br3.readLine();
        oth.add(s3);
        while((s3=br3.readLine())!=null)
        {
            
            oth.add(s3);
        }
        //System.out.println(oth);
        
        
        //starting lexical analysis
        FileReader la=new FileReader("input.txt");
        BufferedReader lex=new BufferedReader(la);
        String str="";
        while((str=lex.readLine())!=null)
        {
            //System.out.println(str);
            
            StringTokenizer token=new StringTokenizer(str," ");
            
            while(token.hasMoreTokens())
            {
                
                String st1=token.nextToken();
                //System.out.println(st1);
                
                if(contains(kw,st1))
                {
                    if(!(contains(fkw,st1)))
                    {
                        fkw.add(st1);
                    }
                }
                else if(contains(lo,st1))
                {
                    if(!(contains(flo,st1)))
                    {
                        flo.add(st1);
                    }
                }
                else if(contains(mo,st1))
                {
                    if(!(contains(fmo,st1)))
                    {
                        fmo.add(st1);
                    }
                    
                }
                else if(contains(oth,st1))
                {
                    if(!(contains(foth,st1)))
                    {
                        foth.add(st1);
                    }
                    
                }
                else if(checkId(st1))
                {
                    if((contains(fid,st1))==false)
                    {
                        fid.add(st1);
                    }
                    
                }
                else if(checkNum(st1))
                {
                    if(!(contains(fnum,st1)))
                    {
                        fnum.add(st1);
                    }
                    
                }
                        
                            
                        
                        
                          
            }
        }
        
        System.out.println("Keywords: "+fkw);
        System.out.println();
        System.out.println("Logic Operators: "+flo);
        System.out.println();
        System.out.println("Math Operators: "+fmo);
        System.out.println();
        System.out.println("Others: "+foth);
        System.out.println();
        System.out.println("Identifier: "+fid);
        System.out.println();
        System.out.println("Number: "+fnum);
        System.out.println();
        
    }
    
    public static boolean contains(ArrayList<String> a,String item)
    {
        for (int i = 0; i < a.size(); i++) {
            if(item.equals(a.get(i)))
            {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkId(String item)
    {
        for (int i = 0; i < item.length(); i++) {
            if((item.charAt(0)>=48)&&(item.charAt(0)<=57))
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkNum(String item)
    {
        try
        {
            Double d=Double.parseDouble(item);
        }
        catch(Exception e1)
        {
            return false;
        }
        return true;
    }
    
}
