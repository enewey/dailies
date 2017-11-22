    var nums = [
        '82156821568221',
        '11111011110111011',
        '98778912332145',
        '124489903108444899'
    ];

    function repeat(seq) {
        console.log("######### "+seq+" #########");
        var dict = {};
        for (var i=2; i<seq.length; i++) {
            for (var j=0; j<seq.length + 1 - i; j++) {
                var key = seq.substring(j, j+i);
                if (dict[key]) dict[key]++;
                else dict[key] = 1;
            }
        }
        var printed = false
        for (var k in dict) {
            if (dict[k] > 1) {
                printed = true
                console.log(k +" : "+ dict[k]);
            }
        }
        if (!printed) console.log(0);
    }
    nums.forEach(n => repeat(n));
