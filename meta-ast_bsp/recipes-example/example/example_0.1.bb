SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

# ref : http://yi-jyun.blogspot.com/2018/05/yocto-5-recipes-task.html

do_msg:append () {
    bbwarn "this is debug message from example bb shell"
}


python do_msg:append() {
    import time
    bb.warn( "this is debug message from example_bb python %s" % ( time.strftime('%Y%m%d', time.gmtime())))
}

addtask do_msg before do_fetch


python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

python do_unpack:append() {
#print("Hello, this is a debug message from u-boot bbapend - do_unpack")	
bb.warn("Hello, this is a debug message from example.bb - do_unpack")
}

do_install:append(){
        bbwarn "Hello, this is a debug message from example.bb - do_install"
}

do_configure:append(){
        bbwarn "Hello, this is a debug message from example.bb - do_configure"
}

do_compile:append(){
	bbwarn "Hello, this is a debug message from example.bb - do_compile"
}





addtask display_banner before do_build
