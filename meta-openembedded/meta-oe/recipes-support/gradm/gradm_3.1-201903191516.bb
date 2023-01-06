SUMMARY = "Administration program for the grsecurity RBAC syste"
DESCRIPTION = "\
gradm is the userspace RBAC parsing and authentication program for \
grsecurity grsecurity aims to be a complete security system. gradm \
performs several tasks for the RBAC system including authenticated \
via a password to the kernel and parsing rules to be passed to the \
kernel"
HOMEPAGE = "http://grsecurity.net/index.php"
SECTION = "admin"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4641e94ec96f98fabc56ff9cc48be14b"
DEPENDS = "flex-native bison-native ${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"

SRC_URI = "http://grsecurity.net/stable/${BP}.tar.gz \
           file://0001-Makefile-remove-strip.patch \
           file://0001-Makefile-Append-instead-of-overriding-LDFLAGS.patch \
           "
SRC_URI[md5sum] = "5099c715433981d5a3eed8ded7c5bbc0"
SRC_URI[sha256sum] = "d3a0b6383ff97a2054941d71133c737efae66afdd8eef59346c031ae15c75ff3"

S = "${WORKDIR}/gradm"

inherit autotools-brokensep

do_compile() {
    oe_runmake 'CC=${CC}'                               \
               'LIBS='                                  \
               'OPT_FLAGS=${CFLAGS}'                    \
               'LLEX=${STAGING_BINDIR_NATIVE}/lex'      \
               'FLEX=${STAGING_BINDIR_NATIVE}/flex'     \
               'BISON=${STAGING_BINDIR_NATIVE}/bison'   \
               ${@bb.utils.contains('DISTRO_FEATURES', 'pam', ' ', 'nopam', d)}
}

do_install() {
    oe_runmake 'CC=${CC}'                               \
               'DESTDIR=${D}'                           \
               'LIBS='                                  \
               'LLEX=${STAGING_BINDIR_NATIVE}/lex'      \
               'FLEX=${STAGING_BINDIR_NATIVE}/flex'     \
               'BISON=${STAGING_BINDIR_NATIVE}/bison'   \
               install

    # The device nodes are generated by postinstall or udev
    rm -rf ${D}/dev
}

pkg_postinst_ontarget:${PN}() {
    /bin/mknod -m 0622 /dev/grsec c 1 13
}
