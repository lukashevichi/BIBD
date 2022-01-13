(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'kotlin-wrappers-kotlin-react-dom-js-legacy', 'kotlinx-html-js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('kotlin-wrappers-kotlin-react-dom-js-legacy'), require('kotlinx-html-js'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'bibd_polyclinic'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'bibd_polyclinic'.");
    }if (typeof this['kotlin-wrappers-kotlin-react-dom-js-legacy'] === 'undefined') {
      throw new Error("Error loading module 'bibd_polyclinic'. Its dependency 'kotlin-wrappers-kotlin-react-dom-js-legacy' was not found. Please, check whether 'kotlin-wrappers-kotlin-react-dom-js-legacy' is loaded prior to 'bibd_polyclinic'.");
    }if (typeof this['kotlinx-html-js'] === 'undefined') {
      throw new Error("Error loading module 'bibd_polyclinic'. Its dependency 'kotlinx-html-js' was not found. Please, check whether 'kotlinx-html-js' is loaded prior to 'bibd_polyclinic'.");
    }root.bibd_polyclinic = factory(typeof bibd_polyclinic === 'undefined' ? {} : bibd_polyclinic, kotlin, this['kotlin-wrappers-kotlin-react-dom-js-legacy'], this['kotlinx-html-js']);
  }
}(this, function (_, Kotlin, $module$kotlin_wrappers_kotlin_react_dom_js_legacy, $module$kotlinx_html_js) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var Unit = Kotlin.kotlin.Unit;
  var render = $module$kotlin_wrappers_kotlin_react_dom_js_legacy.react.dom.render_2955dm$;
  var setOf = Kotlin.kotlin.collections.setOf_mh5how$;
  var html = $module$kotlinx_html_js.kotlinx.html;
  function main$lambda$lambda($receiver) {
    return Unit;
  }
  function main$lambda(it) {
    render(document.getElementById('root'), void 0, main$lambda$lambda);
    return Unit;
  }
  function main() {
    window.onload = main$lambda;
  }
  _.main = main;
  $$importsForInline$$['kotlinx-html-js'] = $module$kotlinx_html_js;
  main();
  return _;
}));

//# sourceMappingURL=bibd_polyclinic.js.map
