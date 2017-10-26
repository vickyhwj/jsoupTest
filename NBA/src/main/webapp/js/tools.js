function getMax(array,pro){
    var max=-9999;
    for(var i=0;i<array;++i)
        if(array[i][pro]>max)
            max=array[i][pro];
    return max;
}
function getMin(array,pro){
    var min=9999;
    for(var i=0;i<array;++i)
        if(array[i][pro]<min)
            min=array[i][pro];
    return min;
}