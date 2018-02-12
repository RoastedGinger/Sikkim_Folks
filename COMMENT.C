# include<stdio.h>
# include<conio.h>
void main()
{
  char comment[10];
  int i,j,flag=0;
  printf("enter comment \n");
  gets(comment);
      for(i=0;i<=9;i++)
      {
       if(comment[i] == '/' && comment[i+1] == '/') {
       printf("comment encountered in %d and %d index",i,i+1);
       break;
       }
	 else if(comment[i] == '/' && comment[i+1] == '*')
	      {

		   for(j=i+2;j<=9;j++)
		    {
		     if(comment[j] == '*' && comment[j+1] == '/')
		      {
			flag=1;
			printf("comment started from %d",i);
			printf("comment ended at %d ",j+1);
		      }
		    }
		  if(flag==1)
		  printf("its a comment");
		  else
		  printf("its not comment");

	      break;
	      }
       }
 // printf(comment);
  getch();
}
