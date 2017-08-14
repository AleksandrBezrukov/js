function reversewords(pvalue1)
{
	var words=pvalue1.split(" ");
	var result="";
	for(var i=0;i<words.length;i++)
	{
		var buffer="";
		for(var j=words[i].length;j>=0;j--)
		{
			buffer+=words[i].charAt(j);
		}
		result+=buffer+" ";

	}
	console.log(result);

}
