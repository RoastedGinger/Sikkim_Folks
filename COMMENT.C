# include<stdio.h>
# include<conio.h>
void main()
{
  char comment[10];
  int i,j;
  printf("enter comment \n");
  gets(comment);
      for(i=0;i<=9;i++)
      {
       if(comment[i] == '/' && comment[i+1] == '/')
       printf("comment encountered in %d and %d index",i,i+1);
	 else if(comment[i] == '/' && comment[i+1] == '*')
	      {
		printf("comment started from %d",i);
		   for(j=i+2;j<=9;j++)
		    {
		     if(comment[j] == '*' && comment[j+1] == '/')
		      {
			printf("comment ended at %d ",j+1);
		      }
		    }
	      }
	      else
	      {
	      printf("no comments");
	      break;
	      }
       }
 // printf(comment);
  getch();
}