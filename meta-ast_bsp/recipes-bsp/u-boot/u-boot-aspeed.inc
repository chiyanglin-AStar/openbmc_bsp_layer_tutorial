inherit image_version

do_patch[depends] += "os-release:do_populate_sysroot"

python do_patch:append:aspeed:df-obmc-ubi-fs () {
    version_id=do_get_versionID(d)
    d.setVar('VERSION_ID', version_id)
    bb.build.exec_func("patch_kernelname", d)
}

patch_kernelname () {
    sed -ri "s/kernel-(0|[a-fA-F0-9]{8})/kernel-${VERSION_ID}/g" \
    ${S}/include/configs/ast-common.h &> /dev/null
}
