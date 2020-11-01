#!/bin/sh

echo "Helo world am running"

#for i in 1 2 3 4 5 
#do
#  echo "output: $i";
#done

i=0
while [ $i -lt 10 ]
do
  echo "output while: $i";
  i=`expr $i + 1`
done
