package dreamproject;

public class PolyAlgo {

	
	
	public String encrypt(String text, String key) {
		String sb="";
		String tmp="";
		int k=key.length();
		int j = 0;
		double len =text.length();
		for(int i = 0; i<text.length();i++)
		{	
			
			if(j==(k-1))
				j=0;
			else 
				j++;
	
			if(text.charAt(i)=='\n' ||text.charAt(i)=='\t'||text.charAt(i)==' '){
				sb+=(char)text.charAt(i);				
			}
			
			else{		
			
			int plainInt = text.charAt(i)-32;
			int keyInt =key.charAt(j)-32; 
			
			int tot=plainInt + keyInt;
			
			int c= (tot) % 94;		//here i am considering charecters between 32-126 = 94
			
			c+=32;	//to start charecter from 32 & above ascii vals
			
			sb+=(char)c;
			}
		}
		return sb;
	}
	

public String decrypt(String sb, String key) 
{
String decrypted = "";
int k=key.length();
int j = 0;
int len =sb.length();

for(int i = 0; i<len;i++)
{
	if(j==(k-1))
		j=0;
	else  
		j++;
	
	if(sb.charAt(i)=='\n' || sb.charAt(i)=='\t'|| sb.charAt(i)==' '){
		decrypted+=(char)sb.charAt(i);				
	}
	
	else{
	int plainInt = sb.charAt(i);				
	int keyInt =key.charAt(j); 
	int tot=plainInt - keyInt;
	
	if(tot<0)
		tot= tot + 94;		//here i am considering charecters between 32-126 = 94
	
	char c= (char)(tot+32);			//to start charecter for 32 & above
	
	decrypted+=c;
	}
}
return decrypted;
}

}
