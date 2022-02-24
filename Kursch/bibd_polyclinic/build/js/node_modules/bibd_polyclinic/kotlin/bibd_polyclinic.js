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
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Unit = Kotlin.kotlin.Unit;
  var render = $module$kotlin_wrappers_kotlin_react_dom_js_legacy.react.dom.render_2955dm$;
  var set_title = $module$kotlinx_html_js.kotlinx.html.set_title_ueiko3$;
  var set_id = $module$kotlinx_html_js.kotlinx.html.set_id_ueiko3$;
  var setOf = Kotlin.kotlin.collections.setOf_mh5how$;
  var set_classes = $module$kotlinx_html_js.kotlinx.html.set_classes_njy09m$;
  var attributesMapOf = $module$kotlinx_html_js.kotlinx.html.attributesMapOf_alerag$;
  var META_init = $module$kotlinx_html_js.kotlinx.html.META;
  var visitTag = $module$kotlinx_html_js.kotlinx.html.visitTag_xwv8ym$;
  var LINK_init = $module$kotlinx_html_js.kotlinx.html.LINK;
  var A_init = $module$kotlinx_html_js.kotlinx.html.A;
  var attributesMapOf_0 = $module$kotlinx_html_js.kotlinx.html.attributesMapOf_jyasbz$;
  var LI_init = $module$kotlinx_html_js.kotlinx.html.LI;
  var UL_init = $module$kotlinx_html_js.kotlinx.html.UL;
  var H1_init = $module$kotlinx_html_js.kotlinx.html.H1;
  var P_init = $module$kotlinx_html_js.kotlinx.html.P;
  var IMG_init = $module$kotlinx_html_js.kotlinx.html.IMG;
  var DIV_init = $module$kotlinx_html_js.kotlinx.html.DIV;
  var H2_init = $module$kotlinx_html_js.kotlinx.html.H2;
  var SECTION_init = $module$kotlinx_html_js.kotlinx.html.SECTION;
  var NAV_init = $module$kotlinx_html_js.kotlinx.html.NAV;
  var SCRIPT_init = $module$kotlinx_html_js.kotlinx.html.SCRIPT;
  var html = $module$kotlinx_html_js.kotlinx.html;
  var HEAD_init = $module$kotlinx_html_js.kotlinx.html.HEAD;
  var BODY_init = $module$kotlinx_html_js.kotlinx.html.BODY;
  var enumEncode = $module$kotlinx_html_js.kotlinx.html.attributes.enumEncode_m4whry$;
  var BUTTON_init = $module$kotlinx_html_js.kotlinx.html.BUTTON;
  var TR_init = $module$kotlinx_html_js.kotlinx.html.TR;
  var TD_init = $module$kotlinx_html_js.kotlinx.html.TD;
  var THEAD_init = $module$kotlinx_html_js.kotlinx.html.THEAD;
  var TBODY_init = $module$kotlinx_html_js.kotlinx.html.TBODY;
  var TABLE_init = $module$kotlinx_html_js.kotlinx.html.TABLE;
  function Appointment(id, doctor, patient, date, time) {
    this.id = id;
    this.doctor = doctor;
    this.patient = patient;
    this.date = date;
    this.time = time;
  }
  Appointment.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Appointment',
    interfaces: []
  };
  function Appointment_init($this) {
    $this = $this || Object.create(Appointment.prototype);
    Appointment.call($this, -999, null, null, '', '');
    return $this;
  }
  Appointment.prototype.component1 = function () {
    return this.id;
  };
  Appointment.prototype.component2 = function () {
    return this.doctor;
  };
  Appointment.prototype.component3 = function () {
    return this.patient;
  };
  Appointment.prototype.component4 = function () {
    return this.date;
  };
  Appointment.prototype.component5 = function () {
    return this.time;
  };
  Appointment.prototype.copy_s8h3em$ = function (id, doctor, patient, date, time) {
    return new Appointment(id === void 0 ? this.id : id, doctor === void 0 ? this.doctor : doctor, patient === void 0 ? this.patient : patient, date === void 0 ? this.date : date, time === void 0 ? this.time : time);
  };
  Appointment.prototype.toString = function () {
    return 'Appointment(id=' + Kotlin.toString(this.id) + (', doctor=' + Kotlin.toString(this.doctor)) + (', patient=' + Kotlin.toString(this.patient)) + (', date=' + Kotlin.toString(this.date)) + (', time=' + Kotlin.toString(this.time)) + ')';
  };
  Appointment.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.doctor) | 0;
    result = result * 31 + Kotlin.hashCode(this.patient) | 0;
    result = result * 31 + Kotlin.hashCode(this.date) | 0;
    result = result * 31 + Kotlin.hashCode(this.time) | 0;
    return result;
  };
  Appointment.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.doctor, other.doctor) && Kotlin.equals(this.patient, other.patient) && Kotlin.equals(this.date, other.date) && Kotlin.equals(this.time, other.time)))));
  };
  function Department(id, specialization, telephone) {
    this.id = id;
    this.specialization = specialization;
    this.telephone = telephone;
  }
  Department.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Department',
    interfaces: []
  };
  function Department_init($this) {
    $this = $this || Object.create(Department.prototype);
    Department.call($this, -999, '', '');
    return $this;
  }
  Department.prototype.component1 = function () {
    return this.id;
  };
  Department.prototype.component2 = function () {
    return this.specialization;
  };
  Department.prototype.component3 = function () {
    return this.telephone;
  };
  Department.prototype.copy_s4fhmi$ = function (id, specialization, telephone) {
    return new Department(id === void 0 ? this.id : id, specialization === void 0 ? this.specialization : specialization, telephone === void 0 ? this.telephone : telephone);
  };
  Department.prototype.toString = function () {
    return 'Department(id=' + Kotlin.toString(this.id) + (', specialization=' + Kotlin.toString(this.specialization)) + (', telephone=' + Kotlin.toString(this.telephone)) + ')';
  };
  Department.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.specialization) | 0;
    result = result * 31 + Kotlin.hashCode(this.telephone) | 0;
    return result;
  };
  Department.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.specialization, other.specialization) && Kotlin.equals(this.telephone, other.telephone)))));
  };
  function Diagnosis(id, name) {
    this.id = id;
    this.name = name;
  }
  Diagnosis.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Diagnosis',
    interfaces: []
  };
  function Diagnosis_init($this) {
    $this = $this || Object.create(Diagnosis.prototype);
    Diagnosis.call($this, -999, '');
    return $this;
  }
  Diagnosis.prototype.component1 = function () {
    return this.id;
  };
  Diagnosis.prototype.component2 = function () {
    return this.name;
  };
  Diagnosis.prototype.copy_19mbxw$ = function (id, name) {
    return new Diagnosis(id === void 0 ? this.id : id, name === void 0 ? this.name : name);
  };
  Diagnosis.prototype.toString = function () {
    return 'Diagnosis(id=' + Kotlin.toString(this.id) + (', name=' + Kotlin.toString(this.name)) + ')';
  };
  Diagnosis.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.name) | 0;
    return result;
  };
  Diagnosis.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.name, other.name)))));
  };
  function Doctor(id, name, surname, cabinet, telephone, department) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.cabinet = cabinet;
    this.telephone = telephone;
    this.department = department;
  }
  Doctor.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Doctor',
    interfaces: []
  };
  function Doctor_init($this) {
    $this = $this || Object.create(Doctor.prototype);
    Doctor.call($this, -999, '', '', '', '', Department_init());
    return $this;
  }
  Doctor.prototype.component1 = function () {
    return this.id;
  };
  Doctor.prototype.component2 = function () {
    return this.name;
  };
  Doctor.prototype.component3 = function () {
    return this.surname;
  };
  Doctor.prototype.component4 = function () {
    return this.cabinet;
  };
  Doctor.prototype.component5 = function () {
    return this.telephone;
  };
  Doctor.prototype.component6 = function () {
    return this.department;
  };
  Doctor.prototype.copy_xi71ru$ = function (id, name, surname, cabinet, telephone, department) {
    return new Doctor(id === void 0 ? this.id : id, name === void 0 ? this.name : name, surname === void 0 ? this.surname : surname, cabinet === void 0 ? this.cabinet : cabinet, telephone === void 0 ? this.telephone : telephone, department === void 0 ? this.department : department);
  };
  Doctor.prototype.toString = function () {
    return 'Doctor(id=' + Kotlin.toString(this.id) + (', name=' + Kotlin.toString(this.name)) + (', surname=' + Kotlin.toString(this.surname)) + (', cabinet=' + Kotlin.toString(this.cabinet)) + (', telephone=' + Kotlin.toString(this.telephone)) + (', department=' + Kotlin.toString(this.department)) + ')';
  };
  Doctor.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.name) | 0;
    result = result * 31 + Kotlin.hashCode(this.surname) | 0;
    result = result * 31 + Kotlin.hashCode(this.cabinet) | 0;
    result = result * 31 + Kotlin.hashCode(this.telephone) | 0;
    result = result * 31 + Kotlin.hashCode(this.department) | 0;
    return result;
  };
  Doctor.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.name, other.name) && Kotlin.equals(this.surname, other.surname) && Kotlin.equals(this.cabinet, other.cabinet) && Kotlin.equals(this.telephone, other.telephone) && Kotlin.equals(this.department, other.department)))));
  };
  function Patient(id, name, surname, login, psw) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.login = login;
    this.psw = psw;
  }
  Patient.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Patient',
    interfaces: []
  };
  function Patient_init($this) {
    $this = $this || Object.create(Patient.prototype);
    Patient.call($this, -999, '', '', '', '');
    return $this;
  }
  Patient.prototype.component1 = function () {
    return this.id;
  };
  Patient.prototype.component2 = function () {
    return this.name;
  };
  Patient.prototype.component3 = function () {
    return this.surname;
  };
  Patient.prototype.component4 = function () {
    return this.login;
  };
  Patient.prototype.component5 = function () {
    return this.psw;
  };
  Patient.prototype.copy_fcibhm$ = function (id, name, surname, login, psw) {
    return new Patient(id === void 0 ? this.id : id, name === void 0 ? this.name : name, surname === void 0 ? this.surname : surname, login === void 0 ? this.login : login, psw === void 0 ? this.psw : psw);
  };
  Patient.prototype.toString = function () {
    return 'Patient(id=' + Kotlin.toString(this.id) + (', name=' + Kotlin.toString(this.name)) + (', surname=' + Kotlin.toString(this.surname)) + (', login=' + Kotlin.toString(this.login)) + (', psw=' + Kotlin.toString(this.psw)) + ')';
  };
  Patient.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.name) | 0;
    result = result * 31 + Kotlin.hashCode(this.surname) | 0;
    result = result * 31 + Kotlin.hashCode(this.login) | 0;
    result = result * 31 + Kotlin.hashCode(this.psw) | 0;
    return result;
  };
  Patient.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.name, other.name) && Kotlin.equals(this.surname, other.surname) && Kotlin.equals(this.login, other.login) && Kotlin.equals(this.psw, other.psw)))));
  };
  function PatientCard(id, number, address, telephone, dateOfEstablishment, diagnosis) {
    this.id = id;
    this.number = number;
    this.address = address;
    this.telephone = telephone;
    this.dateOfEstablishment = dateOfEstablishment;
    this.diagnosis = diagnosis;
  }
  PatientCard.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'PatientCard',
    interfaces: []
  };
  function PatientCard_init($this) {
    $this = $this || Object.create(PatientCard.prototype);
    PatientCard.call($this, -999, '', '', '', '', Diagnosis_init());
    return $this;
  }
  PatientCard.prototype.component1 = function () {
    return this.id;
  };
  PatientCard.prototype.component2 = function () {
    return this.number;
  };
  PatientCard.prototype.component3 = function () {
    return this.address;
  };
  PatientCard.prototype.component4 = function () {
    return this.telephone;
  };
  PatientCard.prototype.component5 = function () {
    return this.dateOfEstablishment;
  };
  PatientCard.prototype.component6 = function () {
    return this.diagnosis;
  };
  PatientCard.prototype.copy_oo2ll7$ = function (id, number, address, telephone, dateOfEstablishment, diagnosis) {
    return new PatientCard(id === void 0 ? this.id : id, number === void 0 ? this.number : number, address === void 0 ? this.address : address, telephone === void 0 ? this.telephone : telephone, dateOfEstablishment === void 0 ? this.dateOfEstablishment : dateOfEstablishment, diagnosis === void 0 ? this.diagnosis : diagnosis);
  };
  PatientCard.prototype.toString = function () {
    return 'PatientCard(id=' + Kotlin.toString(this.id) + (', number=' + Kotlin.toString(this.number)) + (', address=' + Kotlin.toString(this.address)) + (', telephone=' + Kotlin.toString(this.telephone)) + (', dateOfEstablishment=' + Kotlin.toString(this.dateOfEstablishment)) + (', diagnosis=' + Kotlin.toString(this.diagnosis)) + ')';
  };
  PatientCard.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.number) | 0;
    result = result * 31 + Kotlin.hashCode(this.address) | 0;
    result = result * 31 + Kotlin.hashCode(this.telephone) | 0;
    result = result * 31 + Kotlin.hashCode(this.dateOfEstablishment) | 0;
    result = result * 31 + Kotlin.hashCode(this.diagnosis) | 0;
    return result;
  };
  PatientCard.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.number, other.number) && Kotlin.equals(this.address, other.address) && Kotlin.equals(this.telephone, other.telephone) && Kotlin.equals(this.dateOfEstablishment, other.dateOfEstablishment) && Kotlin.equals(this.diagnosis, other.diagnosis)))));
  };
  function Root(id, telephone, polyclinicName, address) {
    this.id = id;
    this.telephone = telephone;
    this.polyclinicName = polyclinicName;
    this.address = address;
  }
  Root.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Root',
    interfaces: []
  };
  Root.prototype.component1 = function () {
    return this.id;
  };
  Root.prototype.component2 = function () {
    return this.telephone;
  };
  Root.prototype.component3 = function () {
    return this.polyclinicName;
  };
  Root.prototype.component4 = function () {
    return this.address;
  };
  Root.prototype.copy_cgs6fs$ = function (id, telephone, polyclinicName, address) {
    return new Root(id === void 0 ? this.id : id, telephone === void 0 ? this.telephone : telephone, polyclinicName === void 0 ? this.polyclinicName : polyclinicName, address === void 0 ? this.address : address);
  };
  Root.prototype.toString = function () {
    return 'Root(id=' + Kotlin.toString(this.id) + (', telephone=' + Kotlin.toString(this.telephone)) + (', polyclinicName=' + Kotlin.toString(this.polyclinicName)) + (', address=' + Kotlin.toString(this.address)) + ')';
  };
  Root.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.telephone) | 0;
    result = result * 31 + Kotlin.hashCode(this.polyclinicName) | 0;
    result = result * 31 + Kotlin.hashCode(this.address) | 0;
    return result;
  };
  Root.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.telephone, other.telephone) && Kotlin.equals(this.polyclinicName, other.polyclinicName) && Kotlin.equals(this.address, other.address)))));
  };
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
  function visit$lambda(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function meta$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_0(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function link$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_1(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function a$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_2(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function li$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_3(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function ul$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_4(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function h1$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_5(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function p$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_6(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function img$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_7(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function div$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_8(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function h2$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_9(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function section$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_10(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function nav$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_11(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function script$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_12(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function head$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_13(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function body$lambda($receiver) {
    return Unit;
  }
  function index$lambda$lambda($receiver) {
    $receiver.charset = 'UTF-8';
    return Unit;
  }
  function index$lambda$lambda_0($receiver) {
    $receiver.httpEquiv = 'X-UA-Compatible';
    $receiver.content = 'IE=edge';
    return Unit;
  }
  function index$lambda$lambda_1($receiver) {
    $receiver.name = 'viewport';
    $receiver.content = 'width=device-width, initial-scale=1.0';
    return Unit;
  }
  function index$lambda$lambda_2($receiver) {
    $receiver.rel = 'preconnect';
    $receiver.href = 'https://fonts.googleapis.com';
    return Unit;
  }
  function index$lambda($receiver) {
    visitTag(new META_init(attributesMapOf(['name', null, 'content', null, 'charset', null]), $receiver.consumer), visit$lambda(index$lambda$lambda));
    visitTag(new META_init(attributesMapOf(['name', null, 'content', null, 'charset', null]), $receiver.consumer), visit$lambda(index$lambda$lambda_0));
    visitTag(new META_init(attributesMapOf(['name', null, 'content', null, 'charset', null]), $receiver.consumer), visit$lambda(index$lambda$lambda_1));
    visitTag(new LINK_init(attributesMapOf(['href', null, 'rel', null, 'type', null]), $receiver.consumer), visit$lambda_0(index$lambda$lambda_2));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://fonts.gstatic.com', 'rel', 'preconnect', 'type', 'crossorigin']), $receiver.consumer), visit$lambda_0(link$lambda));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,500;0,600;0,700;0,800;1,500;1,600;1,700&display=swap', 'rel', 'stylesheet', 'type', null]), $receiver.consumer), visit$lambda_0(link$lambda));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css', 'rel', 'stylesheet', 'type', null]), $receiver.consumer), visit$lambda_0(link$lambda));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css', 'rel', 'stylesheet', 'type', 'text/css']), $receiver.consumer), visit$lambda_0(link$lambda));
    visitTag(new LINK_init(attributesMapOf(['href', 'css/style.css', 'rel', 'stylesheet', 'type', 'text/css']), $receiver.consumer), visit$lambda_0(link$lambda));
    set_title($receiver, 'Welcome');
    return Unit;
  }
  function index$lambda$lambda_3($receiver) {
    set_id($receiver, 'root');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda($receiver) {
    $receiver.text_61zpoe$('Hospital CRM');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda$lambda($receiver) {
    $receiver.text_61zpoe$('Home');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda($receiver) {
    visitTag(new A_init(attributesMapOf(['href', 'navigation-link', 'target', '/index.html', 'class', null]), $receiver.consumer), visit$lambda_1(index$lambda$lambda$lambda$lambda$lambda$lambda));
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda$lambda_0($receiver) {
    $receiver.text_61zpoe$('Home');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda_0($receiver) {
    visitTag(new A_init(attributesMapOf(['href', 'navigation-link', 'target', 'table.html', 'class', null]), $receiver.consumer), visit$lambda_1(index$lambda$lambda$lambda$lambda$lambda$lambda_0));
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda_0($receiver) {
    visitTag(new LI_init(attributesMapOf_0('class', 'navigation__list-item'), $receiver.consumer), visit$lambda_2(index$lambda$lambda$lambda$lambda$lambda));
    visitTag(new LI_init(attributesMapOf_0('class', 'navigation__list-item'), $receiver.consumer), visit$lambda_2(index$lambda$lambda$lambda$lambda$lambda_0));
    return Unit;
  }
  function index$lambda$lambda$lambda($receiver) {
    set_classes($receiver, setOf('navigation'));
    visitTag(new A_init(attributesMapOf(['href', 'navigation__logo', 'target', '/index.html', 'class', null]), $receiver.consumer), visit$lambda_1(index$lambda$lambda$lambda$lambda));
    visitTag(new UL_init(attributesMapOf_0('class', 'navigation__list'), $receiver.consumer), visit$lambda_3(index$lambda$lambda$lambda$lambda_0));
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda_1($receiver) {
    $receiver.text_61zpoe$('Welcome to our Hospital CRM');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda_2($receiver) {
    $receiver.text_61zpoe$(' Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis corrupti repellendus nulla eius distinctio officiis vitae consequatur quis nobis, sequi quisquam corporis ea accusantium porro quod nostrum modi necessitatibus. Dicta amet velit tempore illo quasi eos, est odio modi aspernatur!');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda_1($receiver) {
    visitTag(new H1_init(attributesMapOf_0('class', 'welcome-title'), $receiver.consumer), visit$lambda_4(index$lambda$lambda$lambda$lambda$lambda_1));
    visitTag(new P_init(attributesMapOf_0('class', 'welcome-text'), $receiver.consumer), visit$lambda_5(index$lambda$lambda$lambda$lambda$lambda_2));
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda$lambda_1($receiver) {
    $receiver.src = 'images/hospital.jpeg';
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda_3($receiver) {
    visitTag(new IMG_init(attributesMapOf(['alt', 'main-image', 'src', null, 'class', null]), $receiver.consumer), visit$lambda_6(index$lambda$lambda$lambda$lambda$lambda$lambda_1));
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda_2($receiver) {
    visitTag(new DIV_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_7(index$lambda$lambda$lambda$lambda$lambda_3));
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda$lambda_2($receiver) {
    $receiver.text_61zpoe$('You can make an appointment right here!');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda$lambda_3($receiver) {
    $receiver.text_61zpoe$('Lorem ipsum dolor sit amet, consectetur adipisicing elit.\n');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda_4($receiver) {
    visitTag(new H2_init(attributesMapOf_0('class', 'appointment-title'), $receiver.consumer), visit$lambda_8(index$lambda$lambda$lambda$lambda$lambda$lambda_2));
    visitTag(new P_init(attributesMapOf_0('class', 'appointment-text'), $receiver.consumer), visit$lambda_5(index$lambda$lambda$lambda$lambda$lambda$lambda_3));
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda$lambda_5($receiver) {
    $receiver.text_61zpoe$('make an appointment');
    return Unit;
  }
  function index$lambda$lambda$lambda$lambda_3($receiver) {
    visitTag(new DIV_init(attributesMapOf_0('class', 'appointment-block'), $receiver.consumer), visit$lambda_7(index$lambda$lambda$lambda$lambda$lambda_4));
    visitTag(new A_init(attributesMapOf(['href', 'table.html', 'target', null, 'class', 'appointment-button']), $receiver.consumer), visit$lambda_1(index$lambda$lambda$lambda$lambda$lambda_5));
    return Unit;
  }
  function index$lambda$lambda$lambda_0($receiver) {
    visitTag(new DIV_init(attributesMapOf_0('class', 'welcome-block'), $receiver.consumer), visit$lambda_7(index$lambda$lambda$lambda$lambda_1));
    visitTag(new DIV_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_7(index$lambda$lambda$lambda$lambda_2));
    visitTag(new SECTION_init(attributesMapOf_0('class', 'section mt-5 appointment'), $receiver.consumer), visit$lambda_9(index$lambda$lambda$lambda$lambda_3));
    return Unit;
  }
  function index$lambda$lambda_4($receiver) {
    set_classes($receiver, setOf('container'));
    visitTag(new NAV_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_10(index$lambda$lambda$lambda));
    visitTag(new SECTION_init(attributesMapOf_0('class', 'section mt-5 intro'), $receiver.consumer), visit$lambda_9(index$lambda$lambda$lambda_0));
    return Unit;
  }
  function index$lambda$lambda_5($receiver) {
    return Unit;
  }
  function index$lambda_0($receiver) {
    visitTag(new DIV_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_7(index$lambda$lambda_3));
    visitTag(new DIV_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_7(index$lambda$lambda_4));
    visitTag(new SCRIPT_init(attributesMapOf(['type', null, 'src', '/static/untitled.js']), $receiver.consumer), visit$lambda_11(index$lambda$lambda_5));
    return Unit;
  }
  function index($receiver) {
    visitTag(new HEAD_init(html.emptyMap, $receiver.consumer), visit$lambda_12(index$lambda));
    visitTag(new BODY_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_13(index$lambda_0));
  }
  function visit$lambda_14(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function meta$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_15(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function link$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_16(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function li$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_17(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function a$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_18(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function ul$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_19(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function button$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_20(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function tr$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_21(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function td$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_22(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function tr$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_23(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function thead$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_24(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function tbody$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_25(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function table$lambda($receiver) {
    return Unit;
  }
  function visit$lambda_26(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function nav$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_27(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function div$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_28(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function script$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_29(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function head$lambda_0($receiver) {
    return Unit;
  }
  function visit$lambda_30(closure$block) {
    return function ($receiver) {
      closure$block($receiver);
      return Unit;
    };
  }
  function body$lambda_0($receiver) {
    return Unit;
  }
  function table$lambda$lambda($receiver) {
    $receiver.httpEquiv = 'X-UA-Compatible';
    return Unit;
  }
  function table$lambda_0($receiver) {
    visitTag(new META_init(attributesMapOf(['name', null, 'content', null, 'charset', 'UTF-8']), $receiver.consumer), visit$lambda_14(meta$lambda_0));
    visitTag(new META_init(attributesMapOf(['name', null, 'content', 'IE=edge', 'charset', null]), $receiver.consumer), visit$lambda_14(table$lambda$lambda));
    visitTag(new META_init(attributesMapOf(['name', 'viewport', 'content', 'width=device-width, initial-scale=1.0', 'charset', null]), $receiver.consumer), visit$lambda_14(meta$lambda_0));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://fonts.googleapis.com', 'rel', 'preconnect', 'type', null]), $receiver.consumer), visit$lambda_15(link$lambda_0));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://fonts.gstatic.com', 'rel', 'preconnect', 'type', 'crossorigin']), $receiver.consumer), visit$lambda_15(link$lambda_0));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,500;0,600;0,700;0,800;1,500;1,600;1,700&display=swap', 'rel', 'stylesheet', 'type', null]), $receiver.consumer), visit$lambda_15(link$lambda_0));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css', 'rel', 'stylesheet', 'type', null]), $receiver.consumer), visit$lambda_15(link$lambda_0));
    visitTag(new LINK_init(attributesMapOf(['href', 'https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css', 'rel', 'stylesheet', 'type', 'text/css']), $receiver.consumer), visit$lambda_15(link$lambda_0));
    visitTag(new LINK_init(attributesMapOf(['href', 'css/style.css', 'rel', 'stylesheet', 'type', 'text/css']), $receiver.consumer), visit$lambda_15(link$lambda_0));
    set_title($receiver, 'Table');
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda($receiver) {
    $receiver.text_61zpoe$('Hospital CRM');
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda($receiver) {
    $receiver.text_61zpoe$('Hospital CRM');
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda_0($receiver) {
    $receiver.text_61zpoe$('Home');
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda_1($receiver) {
    $receiver.text_61zpoe$('Table');
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda_0($receiver) {
    visitTag(new LI_init(attributesMapOf_0('class', 'navigation__list-item'), $receiver.consumer), visit$lambda_16(li$lambda_0));
    visitTag(new A_init(attributesMapOf(['href', 'navigation-link', 'target', 'navigation__logo', 'class', null]), $receiver.consumer), visit$lambda_17(table$lambda$lambda$lambda$lambda$lambda));
    visitTag(new A_init(attributesMapOf(['href', 'navigation-link', 'target', 'index.html', 'class', null]), $receiver.consumer), visit$lambda_17(table$lambda$lambda$lambda$lambda$lambda_0));
    visitTag(new LI_init(attributesMapOf_0('class', 'navigation__list-item'), $receiver.consumer), visit$lambda_16(li$lambda_0));
    visitTag(new A_init(attributesMapOf(['href', 'navigation-link', 'target', '#', 'class', null]), $receiver.consumer), visit$lambda_17(table$lambda$lambda$lambda$lambda$lambda_1));
    return Unit;
  }
  function table$lambda$lambda$lambda($receiver) {
    visitTag(new A_init(attributesMapOf(['href', 'index.html', 'target', 'navigation__logo', 'class', null]), $receiver.consumer), visit$lambda_17(table$lambda$lambda$lambda$lambda));
    visitTag(new UL_init(attributesMapOf_0('class', 'navigation__list'), $receiver.consumer), visit$lambda_18(table$lambda$lambda$lambda$lambda_0));
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda_1($receiver) {
    set_id($receiver, 'add-data-button');
    $receiver.text_61zpoe$('Add Data');
    return Unit;
  }
  function table$lambda$lambda$lambda_0($receiver) {
    visitTag(new BUTTON_init(attributesMapOf(['formenctype', null != null ? enumEncode(null) : null, 'formmethod', null != null ? enumEncode(null) : null, 'name', 'btn btn-primary add-data-btn', 'type', null != null ? enumEncode(null) : null, 'class', null]), $receiver.consumer), visit$lambda_19(table$lambda$lambda$lambda$lambda_1));
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda_0($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda_1($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda_2($receiver) {
    visitTag(new TR_init(attributesMapOf_0('class', 'Column'), $receiver.consumer), visit$lambda_20(table$lambda$lambda$lambda$lambda$lambda$lambda));
    visitTag(new TR_init(attributesMapOf_0('class', 'Column'), $receiver.consumer), visit$lambda_20(table$lambda$lambda$lambda$lambda$lambda$lambda_0));
    visitTag(new TR_init(attributesMapOf_0('class', 'Column'), $receiver.consumer), visit$lambda_20(table$lambda$lambda$lambda$lambda$lambda$lambda_1));
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda$lambda($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_0($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_1($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda_2($receiver) {
    visitTag(new TD_init(attributesMapOf_0('class', 'Data'), $receiver.consumer), visit$lambda_21(table$lambda$lambda$lambda$lambda$lambda$lambda$lambda));
    visitTag(new TD_init(attributesMapOf_0('class', 'Data'), $receiver.consumer), visit$lambda_21(table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_0));
    visitTag(new TD_init(attributesMapOf_0('class', 'Data'), $receiver.consumer), visit$lambda_21(table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_1));
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_2($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_3($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_4($receiver) {
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda$lambda_3($receiver) {
    visitTag(new TD_init(attributesMapOf_0('class', 'Data'), $receiver.consumer), visit$lambda_21(table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_2));
    visitTag(new TD_init(attributesMapOf_0('class', 'Data'), $receiver.consumer), visit$lambda_21(table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_3));
    visitTag(new TD_init(attributesMapOf_0('class', 'Data'), $receiver.consumer), visit$lambda_21(table$lambda$lambda$lambda$lambda$lambda$lambda$lambda_4));
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda$lambda_3($receiver) {
    visitTag(new TR_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_22(table$lambda$lambda$lambda$lambda$lambda$lambda_2));
    visitTag(new TR_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_22(table$lambda$lambda$lambda$lambda$lambda$lambda_3));
    return Unit;
  }
  function table$lambda$lambda$lambda$lambda_2($receiver) {
    set_id($receiver, 'table_id');
    visitTag(new THEAD_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_23(table$lambda$lambda$lambda$lambda$lambda_2));
    visitTag(new TBODY_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_24(table$lambda$lambda$lambda$lambda$lambda_3));
    return Unit;
  }
  function table$lambda$lambda$lambda_1($receiver) {
    visitTag(new TABLE_init(attributesMapOf_0('class', 'display'), $receiver.consumer), visit$lambda_25(table$lambda$lambda$lambda$lambda_2));
    return Unit;
  }
  function table$lambda$lambda_0($receiver) {
    visitTag(new NAV_init(attributesMapOf_0('class', 'navigation'), $receiver.consumer), visit$lambda_26(table$lambda$lambda$lambda));
    visitTag(new DIV_init(attributesMapOf_0('class', 'mt-5 mb-5'), $receiver.consumer), visit$lambda_27(table$lambda$lambda$lambda_0));
    visitTag(new DIV_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_27(table$lambda$lambda$lambda_1));
    return Unit;
  }
  function table$lambda$lambda_1($receiver) {
    $receiver.src = 'https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js';
    return Unit;
  }
  function table$lambda$lambda_2($receiver) {
    $receiver.src = 'https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js';
    return Unit;
  }
  function table$lambda$lambda_3($receiver) {
    $receiver.src = '../javaScript/app.js';
    return Unit;
  }
  function table$lambda_1($receiver) {
    visitTag(new DIV_init(attributesMapOf_0('class', 'container'), $receiver.consumer), visit$lambda_27(table$lambda$lambda_0));
    visitTag(new SCRIPT_init(attributesMapOf(['type', null, 'src', null]), $receiver.consumer), visit$lambda_28(table$lambda$lambda_1));
    visitTag(new SCRIPT_init(attributesMapOf(['type', null, 'src', null]), $receiver.consumer), visit$lambda_28(table$lambda$lambda_2));
    visitTag(new SCRIPT_init(attributesMapOf(['type', null, 'src', null]), $receiver.consumer), visit$lambda_28(table$lambda$lambda_3));
    return Unit;
  }
  function table($receiver) {
    visitTag(new HEAD_init(html.emptyMap, $receiver.consumer), visit$lambda_29(table$lambda_0));
    visitTag(new BODY_init(attributesMapOf_0('class', null), $receiver.consumer), visit$lambda_30(table$lambda_1));
  }
  var package$model = _.model || (_.model = {});
  package$model.Appointment_init = Appointment_init;
  package$model.Appointment = Appointment;
  package$model.Department_init = Department_init;
  package$model.Department = Department;
  package$model.Diagnosis_init = Diagnosis_init;
  package$model.Diagnosis = Diagnosis;
  package$model.Doctor_init = Doctor_init;
  package$model.Doctor = Doctor;
  package$model.Patient_init = Patient_init;
  package$model.Patient = Patient;
  package$model.PatientCard_init = PatientCard_init;
  package$model.PatientCard = PatientCard;
  package$model.Root = Root;
  _.main = main;
  $$importsForInline$$['kotlinx-html-js'] = $module$kotlinx_html_js;
  var package$view = _.view || (_.view = {});
  package$view.index_2lqpi0$ = index;
  package$view.table_2lqpi0$ = table;
  main();
  Kotlin.defineModule('bibd_polyclinic', _);
  return _;
}));

//# sourceMappingURL=bibd_polyclinic.js.map
