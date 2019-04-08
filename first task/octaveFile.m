x=dlmread('AmountOfNumbers.txt');


y=dlmread('addclass collections.MyLinkedList.txt');
y1=dlmread('addclass java.util.LinkedList.txt');
subplot(3,1,1)
plot(x,y1)
hold on
plot(x,y,'r')
title('Comparison of ADD operation')
xlabel('Amount of objects in list (peaces)')
ylabel('Time (nanosec)')
legend('LinkedList', 'MyLinkedList');


z=dlmread('getclass collections.MyLinkedList.txt');
z1=dlmread('getclass java.util.LinkedList.txt');
subplot(3,1,2)
plot(x,z1)
hold on
plot(x,z,'r')
title('Comparison of GET operation')
xlabel('Amount of objects in list (peaces)')
ylabel('Time (nanosec)')


h=dlmread('removeclass collections.MyLinkedList.txt');
h1=dlmread('removeclass java.util.LinkedList.txt');
subplot(3,1,3)
plot(x,h1)
hold on
plot(x,h,'r')
title('Comparison of REMOVE operation')
xlabel('Amount of objects in list (peaces)')
ylabel('Time (nanosec)')



figure()
xx=1:500:20000
yy=interp1(x,y,xx,'linear','extrap'); 
yy1=interp1(x,y1,xx,'linear','extrap'); 
subplot(3,1,1)
plot(xx,yy) 
hold on 
plot(xx,yy1,'r')
title('Comparison of ADD operation')
xlabel('Amount of objects in list (peaces)')
ylabel('Time (nanosec)')
legend('LinkedList', 'MyLinkedList');

zz=interp1(x,z,xx,'linear','extrap');
zz1=interp1(x,z1,xx,'linear','extrap'); 
subplot(3,1,2)
plot(xx,zz,'r') 
hold on  
plot(xx,zz1)
title('Comparison of GET operation')
xlabel('Amount of objects in list (peaces)')
ylabel('Time (nanosec)')


hh=interp1(x,h,xx,'linear','extrap');
hh1=interp1(x,h1,xx,'linear','extrap'); 
subplot(3,1,3)
plot(xx,hh) 
hold on  
plot(xx,hh1,'r')
title('Comparison of REMOVE operation')
xlabel('Amount of objects in list (peaces)')
ylabel('Time (nanosec)')











