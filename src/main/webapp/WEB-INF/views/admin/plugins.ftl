<form action="uploadPlugin" enctype="multipart/form-data" method="post">
    <input type="file" name="plugin"/>
    <button type="submit">Upload plugin</button>
</form>
<@render partial="plugin" collection=plugins/>