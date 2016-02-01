var exec = require('cordova/exec');
var pushyMeTokenID = function(callbacksucess,callbackfail) {
	exec(callbacksucess,callbackfail,"CDVPlushyMePlugin", "pushyMeTokenID", []);
};
module.exports = pushyMeTokenID;
