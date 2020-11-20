import java.io.*;
import java.lang.*;
class PasswordStrength{
    public static void main(String args[])throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int num=0, low=0, upp=0, spec=0, inc=0;
        String pass;
        int sum=0, deduc=0;
        do{
            System.out.println("Enter a password of minimum length 8 characters:");
            pass = br.readLine();
        }while(pass.length()<8);
        int n = pass.length();
        for(int i=0; i<n; i++){
            char c = pass.charAt(i);
            if(Character.isLowerCase(c)){
                low++;
            }
            else if(Character.isUpperCase(c)){
                upp++;
            }
            else if(Character.isDigit(c)){
                num++;
            }
            else{
                spec++;
            }
        }
        sum = n*4;
        if(num>0){
            sum = sum + num*4;
        }
        if(upp>0){
            sum = sum + (n-upp)*2;
        }
        if(low>0){
            sum = sum + (n-low)*2;
        }
        if(spec>0){
            sum = sum + spec*6;
        }
        
        if(num==n){
            deduc +=num;
        }
        if((upp+low)==n){
            deduc += (upp + low);
        }
        if (low==n){
            deduc +=low;
        }
        if (upp==n){
            deduc +=upp;
        }
        //Keep a count of consecutive uppercase, lowercase and numerical characters
        int temp1=0;
        char ch1='\0', ch2='\0';
        for(int j=0; j<n; j++){
            if (j < n - 1){
                ch1 = pass.charAt(j);
                ch2 = pass.charAt(j + 1);
                if (ch2 == ch1){
                    temp1++;
                }
            }

            
        }
        deduc += temp1*2 ;
        
        //Keep a track of sequential characters greater than 3
        int seq = 0;
        char ch3 = '\0';
        for(int i=0; i<n; i++){
            if (i < n- 1){
                ch1 = pass.charAt(i);
                ch2 = pass.charAt(i + 1);
                if ((int)ch2 - (int)ch1 == 1){
                    if (i <= n-3){
                        ch3 = pass.charAt(i + 2);
                        if ((int)ch3 - (int)ch2 == 1){
                            seq++;
                        }
                    }
                }
            }
        }
        deduc += seq*3;
        int score = sum - deduc;
        
        System.out.println("The password score is: "+score);
    }
}