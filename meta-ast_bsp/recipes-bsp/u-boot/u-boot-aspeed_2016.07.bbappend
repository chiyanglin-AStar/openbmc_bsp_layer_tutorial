FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

require u-boot-aspeed.inc
require recipes-bsp/u-boot/u-boot-obmc.inc


# ref : http://yi-jyun.blogspot.com/2018/05/yocto-5-recipes-task.html

do_msg:append () {
    bbwarn "this is debug message from uboot bbappend shell"
}


python do_msg:append() {
    import time
    bb.warn( "this is debug message from uboot bbappend python %s" % ( time.strftime('%Y%m%d', time.gmtime())))
}

#addtask do_msg before do_fetch

python do_unpack:append() {
#print("Hello, this is a debug message from u-boot bbapend - do_unpack")	
bb.warn("Hello, this is a debug message from u-boot bbapend - do_unpack")
}

do_install:append(){
        bbwarn "Hello, this is a debug message from u-boot bbapend - do_install"
}

do_configure:append(){
        bbwarn "Hello, this is a debug message from u-boot bbapend - do_configure"
}

do_compile:append(){
	bbwarn "Hello, this is a debug message from u-boot bbapend - do_compile"
}
