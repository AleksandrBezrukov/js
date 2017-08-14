function fizzbuzz(pnumber)
{
	var result="";
	var i;

	for(i=0;i<101;i++)

		if(i%3==0 && i%5==0) result+="fizzbuzz ";
		else
			if(i%3==0) result+="fizz ";
			else
				if(i%5==0) result+="buzz ";
				else result+=i+" ";

		console.log(result);
}