function triangle(pvalue1)
{
	var result="";

	for (var i=0;i<pvalue1;i++)
	{
		for(var j=0;j<pvalue1;j++)
		{
			if((j==i&&j<pvalue1/2)||i==0||(j+i==pvalue1-1&&j>=pvalue1/2))result+="*";
			else result+=" ";
		}
		result+='\n';
	}

	console.log(result);

}
