x=dlmread('AmountOfNumbers.txt');


y=dlmread('addclass java.util.HashSet.txt');
y1=dlmread('addclass java.util.LinkedHashSet.txt');
y2=dlmread('addclass java.util.TreeSet.txt');

subplot(3,1,1)
plot(x,y,'r')
hold on
plot(x,y1,'g')
hold on
plot(x,y2)
axis([0,20000,0,100000])

title('Comparison of ADD operation')
xlabel('Amount of objects in set (peaces)')
ylabel('Time (nanosec)')
legend('HashSet', 'LinkedHashSet', 'TreeSet');


z=dlmread('getclass java.util.HashSet.txt');
z1=dlmread('getclass java.util.LinkedHashSet.txt');
z2=dlmread('getclass java.util.TreeSet.txt');

subplot(3,1,2)
plot(x,z,'r')
hold on
plot(x,z1,'g')
hold on
plot(x,z2)
axis([0,20000,0,100000])

title('Comparison of CONTAINS operation')
xlabel('Amount of objects in set (peaces)')
ylabel('Time (nanosec)')

h=dlmread('removeclass java.util.HashSet.txt');
h1=dlmread('removeclass java.util.LinkedHashSet.txt');
h2=dlmread('removeclass java.util.TreeSet.txt');

subplot(3,1,3)
plot(x,h,'r')
hold on
plot(x,h1,'g')
hold on
plot(x,h2)
axis([0,20000,0,100000])

title('Comparison of REMOVE operation')
xlabel('Amount of objects in set (peaces)')
ylabel('Time (nanosec)')

figure()
xx=1:1000:20000
yy=interp1(x,y,xx,'linear','extrap'); 
yy1=interp1(x,y1,xx,'linear','extrap'); 
yy2=interp1(x,y2,xx,'linear','extrap'); 

subplot(3,1,1)
plot(xx,yy,'r')
hold on
plot(xx,yy1,'g')
hold on
plot(xx,yy2)
axis([0,20000,0,10000])
title('Comparison of ADD operation')
xlabel('Amount of objects in set (peaces)')
ylabel('Time (nanosec)')
legend('HashSet', 'LinkedHashSet', 'TreeSet');

zz=interp1(x,z,xx,'linear','extrap'); 
zz1=interp1(x,z1,xx,'linear','extrap'); 
zz2=interp1(x,z2,xx,'linear','extrap'); 

subplot(3,1,2)
plot(xx,zz,'r')
hold on
plot(xx,zz1,'g')
hold on
plot(xx,zz2)
axis([0,20000,0,5000])
title('Comparison of CONTAINS operation')
xlabel('Amount of objects in set (peaces)')
ylabel('Time (nanosec)')


hh=interp1(x,h,xx,'linear','extrap'); 
hh1=interp1(x,h1,xx,'linear','extrap'); 
hh2=interp1(x,h2,xx,'linear','extrap'); 

subplot(3,1,3)
plot(xx,hh,'r')
hold on
plot(xx,hh1,'g')
hold on
plot(xx,hh2)
axis([0,20000,0,5000])
title('Comparison of REMOVE operation')
xlabel('Amount of objects in set (peaces)')
ylabel('Time (nanosec)')











