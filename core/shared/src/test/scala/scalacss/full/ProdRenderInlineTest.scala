package scalacss.full

import scalacss.ProdDefaults._

object ProdRenderInlineTest extends utest.TestSuite {
  import japgolly.microlibs.testutil.TestUtil._
  import utest._

  def test(_actual: String, _expect: String): Unit = {
    def norm(css: String) = css.trim
    val actual = norm(_actual)
    val expect = norm(_expect)
    if (actual != expect) {
      def split(css: String) = css.split("(?<=[}])").mkString("\n")
      println()
      println(actual)
      assertMultiline(split(actual), split(expect))
      assertEq(actual, expect)
    }
  }

  override def tests = Tests {
    "css1"        - test(MyInline             .render, """.manual:hover{font-weight:normal;line-height:1em;padding:0;cursor:-moz-zoom-in;cursor:-o-zoom-in;cursor:-webkit-zoom-in;cursor:zoom-in}.manual:not(:first-child):visited{-moz-animation-delay:60s,50ms;-o-animation-delay:60s,50ms;-webkit-animation-delay:60s,50ms;animation-delay:60s,50ms;font-weight:bold;font:inherit}.manual{margin:12px;padding:0.5ex;cursor:pointer;-moz-text-decoration-line:underline overline;text-decoration-line:underline overline;background-image:-moz-radial-gradient(5em circle at top left, yellow, blue);background-image:-o-radial-gradient(5em circle at top left, yellow, blue);background-image:-webkit-radial-gradient(5em circle at top left, yellow, blue);background-image:radial-gradient(5em circle at top left, yellow, blue);-ms-grid-template-areas:"main side";grid-template-areas:"main side"}.manual nav.debug{background-color:#f88;color:black !important}.manual nav.debug h1{line-height:97.5%;font-size:150%}blockquote:before, blockquote:after{content:'';content:none}.DEBUG{border-color:#080}.MyInline-condMixinP:hover{display:block;color:red}@media tv and (min-device-aspect-ratio:3/4), all and (resolution:300dpi){.manual{margin-top:10em;margin-bottom:10em}}@media not handheld and (orientation:landscape) and (color){.manual{padding-left:500px;padding-right:500px}}@media (max-width:100px){.MyInline-medianess{color:brown}.MyInline-medianess span{background-color:yellow}.MyInline-condMixinP:hover{margin:auto}.MyInline-condMixinQ{display:block;margin:auto}.MyInline-condMixinQ:hover{color:red}}""")
    "css2"        - test(MyInline2            .render, ".MyInline2-sb2{margin-top:inherit}.MyInline2-everythingOk-t{background-color:green;max-width:80ex}.MyInline2-everythingOk-f{background-color:red;max-width:80ex}.MyInline2-indent-2{padding-left:8ex;color:blue}.MyInline2-indent-3{padding-left:12ex;color:red;margin-top:1em}.MyInline2-indent-4{padding-left:16ex;margin-top:1em}.MyInline2-opbool-1{color:black}.MyInline2-opbool-2{color:green}.MyInline2-opbool-3{color:red}.MyInline2-what_the_hell__{visibility:hidden}")
    "css3"        - test(MyInline3            .render, """.MyInline3-dup1b{word-break:break-all}.MyInline3-dup1b-2{word-break:keep-all}.MyInline3-dup2c{vertical-align:top}.MyInline3-dup2c-2{vertical-align:middle}.MyInline3-dup2c-3{vertical-align:bottom}.MyInline3-attr01{background-repeat:no-repeat}.MyInline3-attr02{background-repeat:round}.MyInline3-attr03{background-repeat:repeat space}.MyInline3-attr04{initial-letter:3}.MyInline3-attr05{initial-letter:3.2 5}.blah-t{background-color:green;max-width:80ex}.blah-f{background-color:red;max-width:80ex}.MyInline3-innerObject-depth1{border-collapse:collapse}.MyInline3-innerObject-andAgain-depth2{border-collapse:separate}""")
    "keyframes"   - test(MyInlineWithKeyframes.render, """@keyframes MyInlineWithKeyframes-kf1{0%{height:100px;width:30px}20.5%{height:150px;width:30px}25.5%{height:150px;width:30px}30.5%{height:150px;width:30px}35.5%{height:150px;width:30px}100%{height:200px;width:60px}}.MyInlineWithKeyframes-s{height:100px;width:30px}.MyInlineWithKeyframes-animation{-moz-animation-name:MyInlineWithKeyframes-kf1;-o-animation-name:MyInlineWithKeyframes-kf1;-webkit-animation-name:MyInlineWithKeyframes-kf1;animation-name:MyInlineWithKeyframes-kf1;-moz-animation-duration:5s;-o-animation-duration:5s;-webkit-animation-duration:5s;animation-duration:5s;-moz-animation-direction:alternate;-o-animation-direction:alternate;-webkit-animation-direction:alternate;animation-direction:alternate;-moz-animation-iteration-count:5;-o-animation-iteration-count:5;-webkit-animation-iteration-count:5;animation-iteration-count:5;-moz-animation-play-state:running;-o-animation-play-state:running;-webkit-animation-play-state:running;animation-play-state:running;-moz-animation-timing-function:ease;-o-animation-timing-function:ease;-webkit-animation-timing-function:ease;animation-timing-function:ease}""")
    "complexCond" - test(MyInlineComplexCond  .render, ".manual{margin:12px;padding:0.5ex}.manual:hover{cursor:-moz-zoom-in;cursor:-o-zoom-in;cursor:-webkit-zoom-in;cursor:zoom-in}.manual:nth-child(5){cursor:-moz-zoom-in;cursor:-o-zoom-in;cursor:-webkit-zoom-in;cursor:zoom-in}.manual[some-attribute=\"true\"]::after{padding:5px}.manual:hover .child:hover{display:block}.manual:hover .child{margin:5px}.manual .child2:hover{margin:15px}.manual:nth-child(5) .row:nth-child(9){display:block}.manual:nth-child(5) .row{margin:5px}.manual .row2:nth-child(15){margin:15px}@media (max-width:150px){.manual:hover{margin:0}.manual:nth-child(5){margin:0}}@media (max-width:100px){.manual:hover .child{margin:2px}.manual .child2:hover{margin:10px}.manual:nth-child(5) .row{margin:2px}.manual .row2:nth-child(15){margin:10px}}")
    "fontFaces"   - test(MyInlineWithFontFace .render, "@font-face {font-family:myFont;src:url(font.woff);font-stretch:expanded;font-style:italic;unicode-range:U+0-5}@font-face {font-family:myFont2;src:url(font2.woff);font-style:oblique;font-weight:200}@font-face {font-family:myFont3;src:local(HelveticaNeue),url(font2.woff);font-stretch:ultra-condensed;font-weight:200}@font-face {font-family:myFont3;src:local(HelveticaNeue),url(font2.woff)}@font-face {font-family:MyInlineWithFontFace-0001;src:local(HelveticaNeue),url(font2.woff)}@font-face {font-family:MyInlineWithFontFace-0002;src:local(HelveticaNeue),url(font.woff)}.MyInlineWithFontFace-myFontText{font-family:myFont}.MyInlineWithFontFace-myFontText2{font-family:myFont3}.MyInlineWithFontFace-myFontText3{font-family:MyInlineWithFontFace-0002}")
  }
}