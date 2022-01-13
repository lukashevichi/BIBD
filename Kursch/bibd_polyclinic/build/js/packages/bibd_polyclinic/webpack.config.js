let config = {
  mode: 'production',
  resolve: {
    modules: [
      "node_modules"
    ]
  },
  plugins: [],
  module: {
    rules: []
  }
};

// entry
config.entry = {
    main: ["D:\\BSUIR\\ASOI4.1\\BIBD\\Kursch\\bibd_polyclinic\\build\\js\\packages\\bibd_polyclinic\\kotlin-dce\\bibd_polyclinic.js"]
};

config.output = {
    path: "D:\\BSUIR\\ASOI4.1\\BIBD\\Kursch\\bibd_polyclinic\\build\\distributions",
    filename: (chunkData) => {
        return chunkData.chunk.name === 'main'
            ? "bibd_polyclinic.js"
            : "bibd_polyclinic-[name].js";
    },
    library: "bibd_polyclinic",
    libraryTarget: "umd",
    globalObject: "this"
};

// resolve modules
config.resolve.modules.unshift("D:\\BSUIR\\ASOI4.1\\BIBD\\Kursch\\bibd_polyclinic\\build\\js\\packages\\bibd_polyclinic\\kotlin-dce")

// source maps
config.module.rules.push({
        test: /\.js$/,
        use: ["source-map-loader"],
        enforce: "pre"
});
config.devtool = 'source-map';
config.ignoreWarnings = [/Failed to parse source map/]

// Report progress to console
// noinspection JSUnnecessarySemicolon
;(function(config) {
    const webpack = require('webpack');
    const handler = (percentage, message, ...args) => {
        const p = percentage * 100;
        let msg = `${Math.trunc(p / 10)}${Math.trunc(p % 10)}% ${message} ${args.join(' ')}`;
        msg = msg.replace(new RegExp("D:\\BSUIR\\ASOI4.1\\BIBD\\Kursch\\bibd_polyclinic\\build\\js", 'g'), '');;
        console.log(msg);
    };

    config.plugins.push(new webpack.ProgressPlugin(handler))
})(config);

// css settings
;(function(config) {
    ;(function(config) {
       const use = [
           {
               loader: 'css-loader',
               options: {},
           }
       ]
       use.unshift({
           loader: 'style-loader',
           options: {}
       })
       
       config.module.rules.push({
           test: /\.css$/,
           use: use,
           
           
       })

   })(config);
            
})(config);

// noinspection JSUnnecessarySemicolon
;(function(config) {
    const tcErrorPlugin = require('kotlin-test-js-runner/tc-log-error-webpack');
    config.plugins.push(new tcErrorPlugin())
    config.stats = config.stats || {}
    Object.assign(config.stats, config.stats, {
        warnings: false,
        errors: false
    })
})(config);
// save evaluated config file
;(function(config) {
    const util = require('util');
    const fs = require('fs');
    const evaluatedConfig = util.inspect(config, {showHidden: false, depth: null, compact: false});
    fs.writeFile("D:\\BSUIR\\ASOI4.1\\BIBD\\Kursch\\bibd_polyclinic\\build\\reports\\webpack\\bibd_polyclinic\\webpack.config.evaluated.js", evaluatedConfig, function (err) {});
})(config);

module.exports = config
