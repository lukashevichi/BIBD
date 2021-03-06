{
  mode: 'production',
  resolve: {
    modules: [
      'E:\\BSUIR\\ASOI4.1\\BIBD\\Practice\\Kursch\\bibd_polyclinic\\build\\js\\packages\\bibd_polyclinic\\kotlin-dce',
      'node_modules'
    ]
  },
  plugins: [
    ProgressPlugin {
      profile: false,
      handler: [Function: handler],
      modulesCount: 5000,
      dependenciesCount: 10000,
      showEntries: true,
      showModules: true,
      showDependencies: true,
      showActiveModules: false,
      percentBy: undefined
    },
    TeamCityErrorPlugin {}
  ],
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          'source-map-loader'
        ],
        enforce: 'pre'
      },
      {
        test: /\.css$/,
        use: [
          {
            loader: 'style-loader',
            options: {}
          },
          {
            loader: 'css-loader',
            options: {}
          }
        ]
      }
    ]
  },
  entry: {
    main: [
      'E:\\BSUIR\\ASOI4.1\\BIBD\\Practice\\Kursch\\bibd_polyclinic\\build\\js\\packages\\bibd_polyclinic\\kotlin-dce\\bibd_polyclinic.js'
    ]
  },
  output: {
    path: 'E:\\BSUIR\\ASOI4.1\\BIBD\\Practice\\Kursch\\bibd_polyclinic\\build\\distributions',
    filename: [Function: filename],
    library: 'bibd_polyclinic',
    libraryTarget: 'umd',
    globalObject: 'this'
  },
  devtool: 'source-map',
  ignoreWarnings: [
    /Failed to parse source map/
  ],
  stats: {
    warnings: false,
    errors: false
  }
}