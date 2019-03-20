String.format = function (s) {
	var a = Array.prototype.splice.call(arguments, 1);
	return s.replace(/{(\d+)}/g, function (m, i) {
		return a[i];
	});
};