function chessdesk(pvalue1)
{
	var result="";
	var sz=8;
	var desk=[];
var counter=0;
	for(var i=0;i<70;i++){desk.push('_');desk.push('*');}

	for(var j=0;j<63;j++)
	{
		if(counter==8)
		{
			result+="\n";
			counter=0;
		}
		else 
			{
				result+=desk[j];
				counter++;
			}

	}

	console.log(result);

}
